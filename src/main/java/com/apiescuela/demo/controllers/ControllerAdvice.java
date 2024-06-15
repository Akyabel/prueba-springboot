package com.apiescuela.demo.controllers;

import com.apiescuela.demo.exceptions.EmptyException;
import com.apiescuela.demo.utils.ModelError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = EmptyException.class)
    public ResponseEntity<ModelError> validacionEntrada(EmptyException emptyException){
        ModelError modelError = new ModelError(emptyException.getMessage(), emptyException.getErrorCode());
        return new ResponseEntity<>(modelError, emptyException.getStatus());
    }
}
