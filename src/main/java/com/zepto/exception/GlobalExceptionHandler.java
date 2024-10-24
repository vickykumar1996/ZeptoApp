package com.zepto.exception;

import com.zepto.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest web) {

        ErrorDto errorDto = new ErrorDto(e.getMessage() , new Date() , web.getDescription(true));
        return  new ResponseEntity<>(errorDto , HttpStatus.OK);
    }

    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
       Map<String,String> errors= new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error)->{
           String fieldName = ((FieldError)error).getField();
           String errorMessage = error.getDefaultMessage();
           errors.put(fieldName,errorMessage);
       });
       return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>globalHandel (Exception e){
        return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}