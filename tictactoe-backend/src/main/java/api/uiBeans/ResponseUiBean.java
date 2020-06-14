package api.uiBeans;

public class ResponseUiBean {
    private int code;
    private Object responseObject;

    public ResponseUiBean(){}

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(final Object responseObject) {
        this.responseObject = responseObject;
    }
}
