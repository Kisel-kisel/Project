package com.example.kisialeuskijavapizzaproject.controller.DeafultHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DeafultHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handle(Exception o){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
