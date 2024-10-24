package com.zepto.exception;

import com.zepto.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest web) {

        ErrorDto errorDto = new ErrorDto(e.getMessage() , new Date() , web.getDescription(true));
        return  new ResponseEntity<>(errorDto , HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>globalHandel (Exception e){
        return new ResponseEntity<>(e.getMessage() , HttpStatus.OK);
    }
}