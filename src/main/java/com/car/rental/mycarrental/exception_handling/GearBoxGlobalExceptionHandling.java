package com.car.rental.mycarrental.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GearBoxGlobalExceptionHandling {
    @ExceptionHandler
    public ResponseEntity<GearBoxIncorrectData> handleException(NoSuchFuelException exception) {
        GearBoxIncorrectData gearBoxIncorrectData = new GearBoxIncorrectData();
        gearBoxIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(gearBoxIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GearBoxIncorrectData> handleException(Exception exception) {
        GearBoxIncorrectData gearBoxIncorrectData = new GearBoxIncorrectData();
        gearBoxIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(gearBoxIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
