package exception;

/**
 * @author wuhui
 * @date 2019/5/21 18:48
 */
public class HttpException extends Exception {

    private String msg;

    private Integer code;

    public HttpException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
    public HttpException(Integer code, String msg, Throwable e){
        super(msg,e);
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
