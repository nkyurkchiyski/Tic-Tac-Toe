package api.uiBeans;

public class ErrorUiBean {
    private final Class<?> exceptionClass;

    private final String message;

    public ErrorUiBean(final Class<?> exceptionClass,
                       final String message) {
        this.exceptionClass = exceptionClass;
        this.message = message;
    }

    public Class<?> getExceptionClass() {
        return exceptionClass;
    }

    public String getMessage() {
        return message;
    }
}
