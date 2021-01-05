package com.oktenweb.project.project.Controller;

import com.oktenweb.project.project.Entity.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        String message = "Object " +
                fieldError.getObjectName() +
                ", field " +
                fieldError.getField() +
                " - " +
                fieldError.getDefaultMessage();

        log.warn("Handling MethodArgumentNotValidException: " + message);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Handling MethodArgumentNotValidException", message);
    }
}
