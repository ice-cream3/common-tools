/**
 *
 */
package picture;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.MimeTypeUtils;
import util.StringUtils;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.lang.reflect.Field;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {

    public static final String DEFAULT_ENCODING = "utf8";
    public static final String JSON_CONTENT_TYPE = "application/json;chatset=utf8";
    public static final String XML_CONTENT_TYPE = "text/xml";

    private static HttpClient client;

    public void setHttpClient(HttpClient client) {
        HttpUtils.client = client;
    }

    public static void download(String url, File file, Header... header) {
        InputStream in = null;
        FileOutputStream fout = null;
        HttpClient client = createClient(url);
        try {
            HttpGet get = new HttpGet(url);
            if (header != null) {
                for (Header each : header) {
                    get.setHeader(each);
                }
            }
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            in = entity.getContent();
            fout = new FileOutputStream(file);
            int l = -1;
            byte[] tmp = new byte[4096];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l);
            }
            fout.flush();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            // 关闭低层流。
            close(fout);
            close(in);
        }
    }

    public static <T> T get(String url, ResponseHandler<T> handler,
                            Header... header) {
        return get(url, null, handler, header);
    }

    public static <T> T get(String url, Object parameter, ResponseHandler<T> handler,
                            Header... header) {
        T res = null;

        HttpGet get = null;
        try {
            List<NameValuePair> pairList = convertToNameValuePairList(parameter);
            if (!CollectionUtils.isEmpty(pairList)) {
                url = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairList, Consts.UTF_8));
            }

            HttpClient client = createClient(url);
            get = new HttpGet(url);
            if (header != null) {
                for (Header each : header) {
                    get.setHeader(each);
                }
            }
            res = client.execute(get, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (get != null) {
                get.releaseConnection();
            }
        }
        return res;
    }
    public static <T> T getWithConfig(RequestConfig config, String url, Object parameter, ResponseHandler<T> handler,
                                      Header... header) {
        T res = null;

        HttpGet get = null;
        try {
            List<NameValuePair> pairList = convertToNameValuePairList(parameter);
            if (!CollectionUtils.isEmpty(pairList)) {
                url = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairList, Consts.UTF_8));
            }

            HttpClient client = createClient(url);
            get = new HttpGet(url);
            get.setConfig(config);
            if (header != null) {
                for (Header each : header) {
                    get.setHeader(each);
                }
            }
            res = client.execute(get, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (get != null) {
                get.releaseConnection();
            }
        }
        return res;
    }

    public static <T> T postForm(String url, Object parameter,
                                 ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPost post = new HttpPost(url);
        try {
            if (header != null) {
                for (Header each : header) {
                    post.setHeader(each);
                }
            }
            List<NameValuePair> pairList = convertToNameValuePairList(parameter);
            post.setEntity(new UrlEncodedFormEntity(pairList, Consts.UTF_8));

            res = client.execute(post, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            post.releaseConnection();
        }
        return res;
    }

    private static List<NameValuePair> convertToNameValuePairList(Object parameter) {
        List<NameValuePair> pairList = new ArrayList<NameValuePair>();
        if (parameter != null) {
            Field[] fields = FieldUtils.getAllFields(parameter.getClass());
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }

                // 嵌入在url里面的参数（含有UrlEmbedParameter注解的）不拼接在请求体里
                EmbedUrlParameter embedUrlParameter = field.getAnnotation(EmbedUrlParameter.class);
                if (embedUrlParameter == null) {
                    Object value = PropertyUtils.getProperty(parameter, field.getName());
                    if (value != null) {
                        pairList.add(new BasicNameValuePair(field.getName(), String.valueOf(value)));
                    }
                }
            }
        }
        return pairList;
    }

    public static <T> T postJson(String url, ResponseHandler<T> handler) {
        return postJson(url, null, handler, null);
    }

    public static <T> T postJson(String url, String jsonString,
                                 ResponseHandler<T> handler) {
        return postJson(url, jsonString, handler, null);
    }

    public static <T> T postJson(String url, ResponseHandler<T> handler,
                                 Header... header) {
        return postJson(url, null, handler, header);
    }

    public static <T> T postJsonBean(String url, Object param, final Class<T> resultClazz,
                                     Header... header) {
        String jsonString = JsonUtils.toJson(param);
        ResponseHandler<T> handler = new ResponseHandler<T>() {
            public T handleResponse(HttpResponse response)
                    throws ClientProtocolException, IOException {
                if (response.getStatusLine().getStatusCode() == 200) {
                    // http请求正常返回
                    HttpEntity httpEntity = response.getEntity();
                    T obj = JsonUtils.parse(
                            EntityUtils.toString(httpEntity), resultClazz);
                    return obj;
                } else {
                    throw new IllegalStateException("post json bean fail:" + response.getStatusLine().getStatusCode());
                }
            }
        };

        return postJson(url, jsonString, handler, header);
    }

    public static <T> T postJson(String url, String jsonString,
                                 ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPost post = new HttpPost(url);
        try {
            if (header != null) {
                for (Header each : header) {
                    post.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(jsonString)) {
                StringEntity s = new StringEntity(jsonString, DEFAULT_ENCODING);
                s.setContentType(JSON_CONTENT_TYPE);
                post.setEntity(s);
            }

            res = client.execute(post, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            post.releaseConnection();
        }
        return res;
    }


    public static <T> T postJsonWithConfig(RequestConfig config, String url, String jsonString,
                                           ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPost post = new HttpPost(url);
        post.setConfig(config);
        try {
            if (header != null) {
                for (Header each : header) {
                    post.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(jsonString)) {
                StringEntity s = new StringEntity(jsonString, DEFAULT_ENCODING);
                s.setContentType(JSON_CONTENT_TYPE);
                post.setEntity(s);
            }

            res = client.execute(post, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            post.releaseConnection();
        }
        return res;
    }

    public static <T> T putJson(String url, String jsonString,
                                ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPut put = new HttpPut(url);
        try {
            if (header != null) {
                for (Header each : header) {
                    put.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(jsonString)) {
                StringEntity s = new StringEntity(jsonString, DEFAULT_ENCODING);
                s.setContentType(JSON_CONTENT_TYPE);
                put.setEntity(s);
            }

            res = client.execute(put, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            put.releaseConnection();
        }
        return res;
    }

    public static <T> T postXml(String url, String xmlString, String encoding,
                                ResponseHandler<T> handler) {
        return postXml(url, xmlString, encoding, handler, null);
    }

    public static <T> T postXml(String url, String xmlString, ResponseHandler<T> handler) {
        return postXml(url, xmlString, DEFAULT_ENCODING, handler, (Header[]) null);
    }

    public static <T> T postXml(String url, String xmlString, String encoding,
                                ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPost post = new HttpPost(url);
        try {
            if (header != null) {
                for (Header each : header) {
                    post.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(xmlString)) {
                StringEntity s = new StringEntity(xmlString, encoding);
                s.setContentType(XML_CONTENT_TYPE);
                post.setEntity(s);
            }

            res = client.execute(post, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            post.releaseConnection();
        }
        return res;
    }
    public static <T> T postJsonAikucun(String url, String jsonString, String contentType,
                                        ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPost post = new HttpPost(url);
        try {
            if (header != null) {
                for (Header each : header) {
                    post.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(jsonString)) {
                StringEntity s = new StringEntity(jsonString, DEFAULT_ENCODING);
                s.setContentType(contentType);
                post.setEntity(s);
            }

            res = client.execute(post, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            post.releaseConnection();
        }
        return res;
    }

    private static HttpClient createClient(String url) {
        if (client != null) {
            // 采用环境配置的httpClient实例
            return client;
        }

        // 创建HttpClient实例，注意这里创建的是非线程安全的
        HttpClient _client = null;
        if (url.startsWith("https")) {
            _client = createSSLClientDefault();
        } else if (url.startsWith("http")) {
            _client = HttpClients.createDefault();
        }
        return _client;
    }

    private static HttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
                    null, new TrustStrategy() {
                        // 信任所有
                        public boolean isTrusted(X509Certificate[] chain,
                                                 String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static InputStream getUrlInputStream(String url) {
       return getUrlInputStream(url, null);
    }

    public static InputStream getUrlInputStream(String url, Header... header) {
        InputStream in = null;
        FileOutputStream fout = null;
        HttpClient client = createClient(url);
        try {
            HttpGet get = new HttpGet(url);
            if (header != null) {
                for (Header each : header) {
                    get.setHeader(each);
                }
            }
            HttpResponse response = client.execute(get);
            if (response.getEntity().getContentType().getValue().equals(ContentType.create(MimeTypeUtils.IMAGE_JPEG_VALUE).getMimeType()) ||
                    response.getEntity().getContentType().getValue().equals(ContentType.create(MimeTypeUtils.IMAGE_PNG_VALUE).getMimeType())) {
                HttpEntity entity = response.getEntity();
                in = entity.getContent();

                return in;
            } else {
                return in;

            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static InputStream getUrlInputStream(String url, String jsonString, Header... headers) {
        InputStream in = null;
        HttpClient client = createClient(url);
        try {
            HttpPost httpPost = new HttpPost(url);
            if (headers != null) {
                for (Header each : headers) {
                    httpPost.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(jsonString)) {
                StringEntity s = new StringEntity(jsonString, DEFAULT_ENCODING);
                s.setContentType(JSON_CONTENT_TYPE);
                httpPost.setEntity(s);
            }
            HttpResponse response = client.execute(httpPost);

            if (response.getEntity().getContentType().getValue().equals(ContentType.create(MimeTypeUtils.IMAGE_JPEG_VALUE).getMimeType())) {
                HttpEntity entity = response.getEntity();
                in = entity.getContent();

                return in;
            } else {
                return in;

            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    public static <T> T getJson(String url, ResponseHandler<T> handler) {
        return getJson(url, null, handler, null);
    }
    public static <T> T getJson(String url, String jsonString,
                                ResponseHandler<T> handler, Header... header) {
        T res = null;

        HttpClient client = createClient(url);

        HttpPost get = new HttpPost(url);
        try {
            if (header != null) {
                for (Header each : header) {
                    get.setHeader(each);
                }
            }

            if (StringUtils.isNotEmpty(jsonString)) {
                StringEntity s = new StringEntity(jsonString, DEFAULT_ENCODING);
                s.setContentType(JSON_CONTENT_TYPE);
                get.setEntity(s);
            }

            res = client.execute(get, handler);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            get.releaseConnection();
        }
        return res;
    }

    public static void main(String[] args) {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513094366703&di=3b1d8495fb3058f5db004646de920173&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F0dd7912397dda144bb2e128fb9b7d0a20cf486e3.jpg";
        download(url, new File("/alexhome/1.jpg"));
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            // 忽略
        }
    }

}