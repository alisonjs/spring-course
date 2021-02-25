package com.springcourse.resource.exceptions;

import com.springcourse.exceptions.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handlerNotFoundException(NotFoundException e){
        ApiError error =  ApiError.builder().code(HttpStatus.NOT_FOUND.value()).msg(e.getMessage()).date(new Date()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
