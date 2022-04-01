package com.car.rental.mycarrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class  MyCarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCarRentalApplication.class, args);
    }

}
