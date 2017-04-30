package br.com.douglastuiuiu.api.exception;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 2200601707808140208L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
