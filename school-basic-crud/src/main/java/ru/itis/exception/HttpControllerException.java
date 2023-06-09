package ru.itis.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class HttpControllerException extends RuntimeException{

    private static final HttpStatus HTTP_DEFAULT_ERROR_STATUS = HttpStatus.BAD_REQUEST;
    private static final String HTTP_DEFAULT_ERROR_MESSAGE = "Ошибка на стороне сервера";
    private String message;
    private HttpStatus httpStatus;


    public HttpControllerException(String message){
        this.message = message;
        this.httpStatus = HTTP_DEFAULT_ERROR_STATUS;
    }

    public HttpControllerException(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
        this.message = HTTP_DEFAULT_ERROR_STATUS.getReasonPhrase();
    }

    public HttpControllerException(){
        this.message = HTTP_DEFAULT_ERROR_MESSAGE;
        this.httpStatus = HTTP_DEFAULT_ERROR_STATUS;
    }
}
