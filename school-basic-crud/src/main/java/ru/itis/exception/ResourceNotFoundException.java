package ru.itis.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class ResourceNotFoundException extends HttpControllerException{

    private static final HttpStatus HTTP_DEFAULT_NOT_FOUND_STATUS = HttpStatus.NOT_FOUND;
    private static final String HTTP_DEFAULT_NOT_FOUND_MESSAGE = "Ресурс не был найден";

    public ResourceNotFoundException(){
        super(HTTP_DEFAULT_NOT_FOUND_MESSAGE, HTTP_DEFAULT_NOT_FOUND_STATUS);
    }

    public ResourceNotFoundException(UUID uuid){
        super("Ресурс с индентификатором " + uuid + " не был найден", HTTP_DEFAULT_NOT_FOUND_STATUS);
    }

    public ResourceNotFoundException(String message){
        super("Ресурс " + message + " не был найден", HTTP_DEFAULT_NOT_FOUND_STATUS);
    }
}
