package com.car.rental.mycarrental.exception;

public class ExistingRecordException extends RuntimeException{

    public ExistingRecordException(String mess){
        super(String.format("Conflict Exception: %s ",mess));
    }
}
