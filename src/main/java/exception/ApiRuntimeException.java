package exception;

/**
 * Created by wuhui on 2017/7/17.
 */
public class ApiRuntimeException extends RuntimeException{

    private static final long serialVersionUID = -3197616652643414121L;

    private String msg;

    private InfoCode infoCode;

    public ApiRuntimeException(InfoCode infoCode){
        super(infoCode.getMsg());
        this.infoCode = infoCode;
    }

    public ApiRuntimeException(InfoCode infoCode, String msg){
        super(msg);
        this.infoCode = infoCode;
        this.msg = msg;
    }

    public InfoCode getInfoCode() {
        return infoCode;
    }

    public String getMsg() {
        return msg;
    }
}
