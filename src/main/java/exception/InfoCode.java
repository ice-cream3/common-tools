package exception;

/**
 * Created by wuhui on 2017/7/17.
 */
public enum InfoCode {

    SUCCESS(0,"成功"),

    FAIL(1,"失败"),

    NOT_LOGIN(1000,"没有登录或登录已失效"),
    NOT_AUTH(1002,"没有权限"),

    NOT_BIND(930623,"没有绑定微信账号"),

    INVALID_LICENCE(1001,"无效的Licence"),

    NO_CONTENT(2001,"没有内容"),

    LACK_PARAM(2000,"缺少参数"),

    QUERY_NOT(2002,"数量不存在"),

    INVALID_REQUEST(3000,"不支持的请求方式"),

    NOT_FOUND(4000,"没有对应的服务"),

    SERVICE_UNAVAILABLE(5000,"服务异常，请稍后再试"),

    EXPIRE_UNAVAILABLE(5001,"已过期"),

    INTERNAL_ERROR(6000,"系统内部错误");

    private int status;

    private String msg;

    InfoCode(int status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
