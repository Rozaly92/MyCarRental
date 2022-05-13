package com.car.rental.mycarrental.exception;

public class NotExistingGenre extends RuntimeException{

    public NotExistingGenre(String genre){
        super(String.format("There is no genre : %s ",genre));
    }
}
