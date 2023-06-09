package ru.itis.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.controller.error.ErrorMessage;
import ru.itis.exception.HttpControllerException;

@ControllerAdvice
public class HttpControllerHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage serverErrorHandler(Exception e){
        return ErrorMessage.builder()
                .message("Внутрення ошибка сервера")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(HttpControllerException.class)
    public ResponseEntity<ErrorMessage> controllerErrorHandler(HttpControllerException e){
        return ResponseEntity.status(e.getHttpStatus())
                .body(ErrorMessage.builder()
                        .message(e.getMessage())
                        .status(e.getHttpStatus().value())
                        .build());
    }
}
