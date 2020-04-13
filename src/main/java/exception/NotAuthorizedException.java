package exception;

/**
 * @author wuhui
 * @date 2019/7/31 12:14
 */
public class NotAuthorizedException extends RuntimeException {

    private String msg;

    private Integer code;

    public NotAuthorizedException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
    public NotAuthorizedException(Integer code, String msg, Throwable e){
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
