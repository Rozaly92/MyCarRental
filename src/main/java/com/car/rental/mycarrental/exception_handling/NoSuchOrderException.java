package com.car.rental.mycarrental.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoSuchOrderException {
    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(NoSuchFuelException exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(Exception exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
