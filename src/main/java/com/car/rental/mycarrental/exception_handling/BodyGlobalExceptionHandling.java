package com.car.rental.mycarrental.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BodyGlobalExceptionHandling {
    @ExceptionHandler
    public ResponseEntity<BodyIncorrectData> handleException(NoSuchBodyException exception) {
        BodyIncorrectData bodyIncorrectData = new BodyIncorrectData();
        bodyIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(bodyIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BodyIncorrectData> handleException(Exception exception) {
        BodyIncorrectData bodyIncorrectData = new BodyIncorrectData();
        bodyIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(bodyIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
