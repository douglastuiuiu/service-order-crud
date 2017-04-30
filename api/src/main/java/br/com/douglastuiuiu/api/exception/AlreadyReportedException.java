package br.com.douglastuiuiu.api.exception;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class AlreadyReportedException extends ServiceException {
    private static final long serialVersionUID = 6725364835634839120L;

    public AlreadyReportedException() {
        super();
    }

    public AlreadyReportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyReportedException(String message) {
        super(message);
    }

    public AlreadyReportedException(Throwable cause) {
        super(cause);
    }

}
