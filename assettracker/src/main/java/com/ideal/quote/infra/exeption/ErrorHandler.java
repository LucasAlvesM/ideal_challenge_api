package com.ideal.quote.infra.exeption;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public
class ErrorHandler {
    @ExceptionHandler( EntityNotFoundException.class)
    public
    ResponseEntity handle404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    public ResponseEntity handle400(MethodArgumentNotValidException ex) {
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream ().map ( ErrorDataValidation::new ).toList ());
    }

    private record ErrorDataValidation(String field, String message) {
        public ErrorDataValidation( FieldError error ) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
