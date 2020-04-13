package dingding;

import http.HttpClientUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author wuhui
 * @date 2019/3/11 12:17
 */
public class DingDingUtil {

    private static final Logger logger = LoggerFactory.getLogger(DingDingUtil.class);

    private static final String dingdingUrl = "https://oapi.dingtalk.com/robot/send?access_token=";

    public void handler(String content, List<String> addresses, Map<String,String> params) {
        if (addresses == null || addresses.size() <=0){
            return;
        }
        for (String address : addresses) {
            String body = "{\"msgtype\": \"text\", \"text\": {\"content\": \""+content+"\"},\"at\": {\"isAtAll\": true}}";
            try {
                HttpClientUtil.buildPostRequest(dingdingUrl+address).addHeader("Content-Type","application/json;charset=utf-8")
                        .setBody(body).setIgnoreResult(true).setConnectTimeOut(5000).setReadTimeOut(3000).execute();
            } catch (Exception e) {
                logger.error("钉钉发送信息异常", e);
            }
        }
    }

    public static void main(String[] args) {
        // test关键字
        // sendMessageKeyWord();
        // encode();
        // 加密方式
        // sendMessageSecurity();
        // 指定ip方式
        sendMessageIPModel();
    }

    private static void sendMessageIPModel() {
        String content = "content 请查看具体信息,访问地址.@13240026998";
        String body = "{\"msgtype\": \"text\", \"text\": {\"content\": \""+content+"\"},\"at\": {\"atMobiles\": [\"13240026998\"],\"isAtAll\": false}}";
        try {
            String address = "ee93167c153037c0c1d24a93eb8194937d3d3737c1d0f2043d4e92a6f2caefc0";
            String dingdingUrl_local = "https://oapi.dingtalk.com/robot/send?access_token="+address;
            String execute = HttpClientUtil.buildPostRequest(dingdingUrl_local).addHeader("Content-Type", "application/json;charset=utf-8")
                    .setBody(body).setIgnoreResult(true).setConnectTimeOut(5000).setReadTimeOut(3000).execute();
            logger.info("执行结果:{}", execute);
        } catch (Exception e) {
            logger.error("钉钉发送信息异常", e);
        }
    }

    private static void sendMessageSecurity() {
        String content = "content 请查看具体信息,访问地址.@13240026998";
        String body = "{\"msgtype\": \"text\", \"text\": {\"content\": \""+content+"\"},\"at\": {\"atMobiles\": [\"13240026998\"],\"isAtAll\": false}}";
        try {
            long timestamp = System.currentTimeMillis();
            String address = "ea1059fd80ff48a556234e2aed69d2a25ee5f0b2c48e37b08cdbc18a48f31b5d";
            String dingdingUrl_local = "https://oapi.dingtalk.com/robot/send?access_token="+address+"&timestamp="+ timestamp +"&sign="+encode(timestamp);
            String execute = HttpClientUtil.buildPostRequest(dingdingUrl_local).addHeader("Content-Type", "application/json;charset=utf-8")
                    .setBody(body).setIgnoreResult(true).setConnectTimeOut(5000).setReadTimeOut(3000).execute();
            logger.info("执行结果:{}", execute);
        } catch (Exception e) {
            logger.error("钉钉加密方式发送信息异常", e);
        }
    }

    public static String encode(Long timestamp) {
        try {
            String secret = "SECcea92f8a09b1c66b294927fe1032254e70981c3a644538af191802a46566911a";
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
            logger.info("钉钉加密方式,sign={}", sign);
            return sign;
        } catch (Exception e) {
            logger.error("钉钉加密异常.", e);
        }

        return null;
    }

    private static void sendMessageKeyWord() {
        String content = "test content 请查看具体信息,访问地址.13240026998";
        String body = "{\"msgtype\": \"text\", \"text\": {\"content\": \""+content+"\"},\"at\": {\"isAtAll\": false}}";
        try {
            String address = "6a4ba002d495f3491fc99d984ab178c987e03859b3805fd2c6705ba2ebfde9fb";
            String dingdingUrl_local = "https://oapi.dingtalk.com/robot/send?access_token=";
            String execute = HttpClientUtil.buildPostRequest(dingdingUrl_local + address).addHeader("Content-Type", "application/json;charset=utf-8")
                    .setBody(body).setIgnoreResult(true).setConnectTimeOut(5000).setReadTimeOut(3000).execute();
            logger.info("执行结果:{}", execute);
        } catch (Exception e) {
            logger.error("钉钉关键字方式发送信息异常", e);
        }
    }
}
