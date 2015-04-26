package framework.exception;

public final class ReportableException extends RuntimeException {

    public ReportableException(Throwable cause) {
        super(cause);
    }

    public ReportableException(String message, Throwable cause) {
        super(message, cause);
    }

    private static final long serialVersionUID = 1L;
}