package com.springboot.thymeleaf.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    // add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception){
        //create CustomerErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse(
                                             HttpStatus.NOT_FOUND.value(),
                                             exception.getMessage(),
                                             System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // add another to catch any exception
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception){
        //create CustomerErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
