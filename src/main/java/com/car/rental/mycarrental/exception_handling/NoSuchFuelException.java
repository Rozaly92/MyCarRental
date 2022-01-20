package com.car.rental.mycarrental.exception_handling;

public class NoSuchFuelException extends RuntimeException{
    public NoSuchFuelException(String message) {
        super(message);
    }
}
