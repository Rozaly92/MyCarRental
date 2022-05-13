package com.car.rental.mycarrental.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(){
        super(String.format("Invalid request."));
    }
}
