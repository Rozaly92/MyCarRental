package com.car.rental.mycarrental.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarGlobalExceptionHandling {
    @ExceptionHandler
    public ResponseEntity<CarIncorrectData> handleException(NoSuchCarException exception) {
        CarIncorrectData carIncorrectData = new CarIncorrectData();
        carIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(carIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CarIncorrectData> handleException(Exception exception) {
        CarIncorrectData carIncorrectData = new CarIncorrectData();
        carIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(carIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
