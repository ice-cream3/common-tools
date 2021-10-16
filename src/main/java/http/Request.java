package http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpException;
import org.apache.http.client.config.RequestConfig;


/**
 * Http request
 *
 */
public abstract class Request {
	
	// 最大等待时间
	private static final int WAIT_TIMEOUT = 1000;
	// 链接超时时间
	private static final int CONNECT_TIMEOUT = 500;
	// 读取超时时间
	private static final int READ_TIMEOUT = 1000;

	protected int readTimeOut = READ_TIMEOUT;
	
	protected int connectTimeOut = CONNECT_TIMEOUT;
	
	protected int waitTimeOut = WAIT_TIMEOUT;

	/**
	 * 日志中忽略result
     */
	protected boolean ignoreResult = false;

	protected int limitResult = -1;

	
	
	protected  RequestConfig getRequestConfig(){
		return RequestConfig.copy(HttpClientUtil.DEFAULT_REQUEST_CONFIG)
                .setSocketTimeout(readTimeOut)
                .setConnectTimeout(connectTimeOut)
                .setConnectionRequestTimeout(waitTimeOut)
                .build();
	}
	
	/**
	 * 执行请求并返回结果
	 * @return
	 */
	public abstract String execute()throws HttpException;
	/**
	 * 执行请求并返回指定类的对象，此方法在ContextType是 application/json情况下执行正确
	 * @see org.apache.http.entity.ContentType APPLICATION_JSON
	 * @return
	 */
	public abstract JSONObject executeToJson()throws HttpException;
	/**
	 * 执行请求并返回指定类的对象，此方法在ContextType是 application/json情况下执行正确
     * @see org.apache.http.entity.ContentType APPLICATION_JSON
	 * @param clazz
	 * @return
	 */
	public abstract <T>T executeToObject(Class<T> clazz)throws HttpException;


}
