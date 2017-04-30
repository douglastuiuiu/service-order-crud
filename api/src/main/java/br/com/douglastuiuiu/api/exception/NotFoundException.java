package br.com.douglastuiuiu.api.exception;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class NotFoundException extends ServiceException {
    private static final long serialVersionUID = 143003602745884556L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

}
