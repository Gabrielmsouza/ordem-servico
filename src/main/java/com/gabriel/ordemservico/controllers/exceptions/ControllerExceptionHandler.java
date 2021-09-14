package com.gabriel.ordemservico.controllers.exceptions;

import com.gabriel.ordemservico.services.exceptions.DataIntegrityException;
import com.gabriel.ordemservico.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjctNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(
                HttpStatus.NOT_FOUND.value(),
                System.currentTimeMillis(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> DataIntegrityViolation(DataIntegrityException e, HttpServletRequest request){
        StandardError error = new StandardError(
                HttpStatus.CONFLICT.value(),
                System.currentTimeMillis(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> ConstraintViolation(ConstraintViolationException e, HttpServletRequest request){
        StandardError error = new StandardError(
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
