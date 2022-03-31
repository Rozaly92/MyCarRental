package com.car.rental.mycarrental.exception_handling;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Integer id){
        super(String.format("Unable to find the record with ID %d ",id));
    }
}
