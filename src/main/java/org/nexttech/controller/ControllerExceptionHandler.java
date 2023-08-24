package org.nexttech.controller;

import org.nexttech.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({InvalidNameException.class, DuplicateCNPException.class})
    public ResponseEntity<String> handleInvalidDataException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({StudentNotFoundException.class, StudentNotDeletedException.class})
    public ResponseEntity<String> handleNotFoundException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler({StudentNotUniqueCNP.class, StudentNotUniqueCNP.class})
    public ResponseEntity<String> handleInvalidCNPException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
