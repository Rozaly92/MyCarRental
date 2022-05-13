package com.car.rental.mycarrental.exception;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String msg) {
        super(String.format("The service has encountered an issue. Here are the details: %s" ,msg));
    }
}
