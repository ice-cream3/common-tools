package picture;

public enum Currency implements TypeBean {

    CNY(1, "人民币");

    /**
     * 代码
     */
    private int code;

    /**
     * 名称
     */
    private String name;

    Currency(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * @return the code
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;

    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
