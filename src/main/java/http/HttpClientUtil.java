package http;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.*;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.*;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/**
 * 创建Http请求工具类
 * 
 * @author huiwu
 *
 */
public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static PoolingHttpClientConnectionManager connectionManager = null;
	
	public static  RequestConfig DEFAULT_REQUEST_CONFIG = null;

	// 最大连接数
	private static final int MAX_TOTAL_CONNECTIONS = 400;
	// 每个路由最大连接数
	private static final int MAX_ROUTE_CONNECTIONS = 40;
	private static CredentialsProvider provider = new BasicCredentialsProvider();

	/**
	 * 初始化配置
	 */
	static {
		try {
			// Use custom message parser / writer to customize the way HTTP
			// messages are parsed from and written out to the data stream.
			HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {

				@Override
				public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer,
															  MessageConstraints constraints) {
					LineParser lineParser = new BasicLineParser() {

						@Override
						public Header parseHeader(final CharArrayBuffer buffer) {
							try {
								return super.parseHeader(buffer);
							} catch (ParseException ex) {
								return new BasicHeader(buffer.toString(), null);
							}
						}

					};
					return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE,
							constraints) {

						@Override
						protected boolean reject(final CharArrayBuffer line, int count) {
							// try to ignore all garbage preceding a status line infinitely
							return false;
						}

					};
				}

			};

			HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

			// Use a custom connection factory to customize the process of
			// initialization of outgoing HTTP connections. Beside standard connection
			// configuration parameters HTTP connection factory can define message
			// parser / writer routines to be employed by individual connections.
			HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
					requestWriterFactory, responseParserFactory);

			// Client HTTP connection objects when fully initialized can be bound to
			// an arbitrary network socket. The process of network socket initialization,
			// its connection to a remote address and binding to a local one is controlled
			// by a connection socket factory.

			// SSL context for secure connections can be created either based on
			// system or application specific properties.
			SSLContext sslcontext = SSLContext.getInstance("TLS");

			X509TrustManager tm = new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted(X509Certificate[] xcs, String str) {

				}
				public void checkServerTrusted(X509Certificate[] xcs, String str) {

				}
			};
			sslcontext.init(null, new TrustManager[] { tm }, null);

			// Create a registry of custom connection socket factories for supported
			// protocol schemes.
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(sslcontext)).build();

			// Use custom DNS resolver to override the system DNS resolution.
	        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {

	            @Override
	            public InetAddress[] resolve(final String host) throws UnknownHostException {
	                if (host.equalsIgnoreCase("myhost")) {
	                    return new InetAddress[] { InetAddress.getByAddress(new byte[] {127, 0, 0, 1}) };
	                } else {
	                    return super.resolve(host);
	                }
	            }

	        };
	        
	        
	     // Create a connection manager with custom configuration.
	        connectionManager = new PoolingHttpClientConnectionManager(
	                socketFactoryRegistry, connFactory, dnsResolver);

	        // Create socket configuration
	        SocketConfig socketConfig = SocketConfig.custom()
	            .setTcpNoDelay(true)
	            .build();
	        // Configure the connection manager to use socket configuration either
	        // by default or for a specific host.
	        connectionManager.setDefaultSocketConfig(socketConfig);
	        //connManager.setSocketConfig(new HttpHost("somehost", 80), socketConfig);
	        // Validate connections after 1 sec of inactivity
	        connectionManager.setValidateAfterInactivity(1000);

	        // Create message constraints
	        MessageConstraints messageConstraints = MessageConstraints.custom()
	            .setMaxHeaderCount(300)
	            .setMaxLineLength(2000)
	            .build();
	        // Create connection configuration
	        ConnectionConfig connectionConfig = ConnectionConfig.custom()
	            .setMalformedInputAction(CodingErrorAction.IGNORE)
	            .setUnmappableInputAction(CodingErrorAction.IGNORE)
	            .setCharset(Consts.UTF_8)
	            .setMessageConstraints(messageConstraints)
	            .build();
	        // Configure the connection manager to use connection configuration either
	        // by default or for a specific host.
	        connectionManager.setDefaultConnectionConfig(connectionConfig);
	        
	        connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
	        connectionManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
	        
	        DEFAULT_REQUEST_CONFIG = RequestConfig.custom()
	                .setCookieSpec(CookieSpecs.DEFAULT)
	                .setExpectContinueEnabled(true)
	                .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
	                .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
	                .build();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 创建 POST请求 **/
	public static PostRequest buildPostRequest(String url,String userName,String password) throws URISyntaxException {
		return new PostRequest(getHttpClient(url,userName, password), url);
	}

	public static PostRequest buildPostRequest(String url, int retryCount,String userName,String password) throws URISyntaxException {
		return new PostRequest(getHttpClient(url,retryCount,userName,password), url);
	}

	public static PostRequest buildPostRequest(String url, String charset,String userName,String password) throws URISyntaxException {
		return new PostRequest(getHttpClient(url,userName, password), url, charset);
	}

	public static PostRequest buildPostRequest(String url, int retryCount, String charset,String userName,String password) throws URISyntaxException {
		return new PostRequest(getHttpClient(url,retryCount,userName,password), url, charset);
	}

	/** 创建 POST请求 **/
	public static PostRequest buildPostRequest(String url) {
		return new PostRequest(getHttpClient(), url);
	}

	public static PostRequest buildPostRequest(String url, int retryCount) {
		return new PostRequest(getHttpClient(retryCount), url);
	}

	public static PostRequest buildPostRequest(String url, String charset) {
		return new PostRequest(getHttpClient(), url, charset);
	}

	public static PostRequest buildPostRequest(String url, int retryCount, String charset) {
		return new PostRequest(getHttpClient(retryCount), url, charset);
	}

	public static PutRequest buildPutRequest(String url) {
		return new PutRequest(getHttpClient(), url);
	}

	public static PutRequest buildPutRequest(String url, int retryCount) {
		return new PutRequest(getHttpClient(retryCount), url);
	}

	public static PutRequest buildPutRequest(String url, String charset) {
		return new PutRequest(getHttpClient(), url, charset);
	}

	public static PutRequest buildPutRequest(String url, int retryCount, String charset) {
		return new PutRequest(getHttpClient(retryCount), url, charset);
	}

	public static GetRequest buildGetRequest(String url) {
		return new GetRequest(getHttpClient(), url);
	}
	public static GetRequest buildGetRequest(String url,String userName,String password) throws URISyntaxException {
		return new GetRequest(getHttpClient(url,userName,password), url);
	}

	public static GetRequest buildGetRequest(String url, int retryCount) {
		return new GetRequest(getHttpClient(retryCount), url);
	}

	public static GetRequest buildGetRequest(String url, int retryCount,String userName,String password) throws URISyntaxException {
		return new GetRequest(getHttpClient(url,retryCount,userName,password), url);
	}

	public static GetRequest buildGetRequest(String url, String charset) {
		return new GetRequest(getHttpClient(), url, charset);
	}

	public static GetRequest buildGetRequest(String url, String charset,String userName,String password) throws URISyntaxException {
		return new GetRequest(getHttpClient(url,userName,password), url, charset);
	}

	public static GetRequest buildGetRequest(String url, int retryCount, String charset) {
		return new GetRequest(getHttpClient(retryCount), url, charset);
	}

	public static GetRequest buildGetRequest(String url, int retryCount, String charset,String userName,String password) throws URISyntaxException {
		return new GetRequest(getHttpClient(url,retryCount,userName,password), url, charset);
	}

	private static HttpClient getHttpClient() {
		return HttpClients.custom().setDefaultRequestConfig(DEFAULT_REQUEST_CONFIG).setConnectionManager(connectionManager).build();
	}

	private static HttpClient getHttpClient(String url,String userName,String password) throws URISyntaxException {
		URI serverURI = new URI(url);
		provider.setCredentials(new AuthScope(serverURI.getHost(), serverURI.getPort()), new UsernamePasswordCredentials(userName, password));
		return HttpClients.custom().setDefaultRequestConfig(DEFAULT_REQUEST_CONFIG).setDefaultCredentialsProvider(provider).setConnectionManager(connectionManager).build();
	}

	private static HttpClient getHttpClient(int retryCount) {
		return HttpClients.custom().setDefaultRequestConfig(DEFAULT_REQUEST_CONFIG).setRetryHandler(createHttpRequestRetryHandler(retryCount))
				.setConnectionManager(connectionManager).build();
	}

	private static HttpClient getHttpClient(String url,int retryCount,String userName,String password) throws URISyntaxException {
		URI serverURI = new URI(url);
		provider.setCredentials(new AuthScope(serverURI.getHost(), serverURI.getPort()), new UsernamePasswordCredentials(userName, password));
		return HttpClients.custom().setDefaultRequestConfig(DEFAULT_REQUEST_CONFIG).setDefaultCredentialsProvider(provider).setRetryHandler(createHttpRequestRetryHandler(retryCount))
				.setConnectionManager(connectionManager).build();
	}

	private static HttpRequestRetryHandler createHttpRequestRetryHandler(final int retryCount) {
		return new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				logger.info("retry retryCount={},executionCount={}", retryCount, executionCount);
				if (executionCount >= retryCount) {
					return false;
				}
				logger.error("request error", exception);
				return true;
			}
		};
	}
}
