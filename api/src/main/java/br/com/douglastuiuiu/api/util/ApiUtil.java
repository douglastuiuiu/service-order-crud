package br.com.douglastuiuiu.api.util;

import br.com.douglastuiuiu.api.validation.model.ErrorModel;
import br.com.douglastuiuiu.api.validation.model.FieldErrorResponse;
import br.com.douglastuiuiu.api.validation.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ApiUtil {

    private ApiUtil() {
        //vazio
    }

    /**
     * Responta de erro padrão
     *
     * @param message
     * @param status
     * @return
     */
    public static ResponseEntity<Object> responseError(String message, HttpStatus status) {
        ErrorModel body = new ErrorModel(message);
        return new ResponseEntity<>(body, status);
    }

    /**
     * Resposta de erro para validação de dados obrigatórios da API
     * HttpStatus default BAD_REQUEST
     *
     * @param error
     * @return
     */
    public static ResponseEntity<Object> responseErrorValidation(MethodArgumentNotValidException error) {
        return responseErrorValidation(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Resposta de erro para validação de dados obrigatórios da API
     *
     * @param error
     * @param status
     * @return
     */
    public static ResponseEntity<Object> responseErrorValidation(MethodArgumentNotValidException error, HttpStatus status) {
        List<FieldErrorResponse> responseError = ValidationUtil.createFieldErrorResponse(error);
        ErrorModel body = new ErrorModel(responseError);
        return new ResponseEntity<>(body, status);
    }

}
