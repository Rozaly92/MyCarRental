package com.car.rental.mycarrental.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FuelGlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<FuelIncorrectData> handleException(NoSuchFuelException exception){
        FuelIncorrectData fuelIncorrectData = new FuelIncorrectData();
        fuelIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(fuelIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<FuelIncorrectData> handleException(Exception exception){
        FuelIncorrectData fuelIncorrectData = new FuelIncorrectData();
        fuelIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(fuelIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
