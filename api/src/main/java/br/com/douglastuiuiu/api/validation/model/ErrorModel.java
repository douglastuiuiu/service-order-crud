package br.com.douglastuiuiu.api.validation.model;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ErrorModel {
    private Object message;

    public ErrorModel() {

    }

    public ErrorModel(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

}
