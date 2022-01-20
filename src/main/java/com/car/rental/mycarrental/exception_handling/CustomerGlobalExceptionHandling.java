package com.car.rental.mycarrental.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerGlobalExceptionHandling {
    @ExceptionHandler
    public ResponseEntity<CustomerIncorrectData> handleException(NoSuchFuelException exception) {
        CustomerIncorrectData customerIncorrectData = new CustomerIncorrectData();
        customerIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(customerIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerIncorrectData> handleException(Exception exception) {
        CustomerIncorrectData customerIncorrectData = new CustomerIncorrectData();
        customerIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(customerIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
