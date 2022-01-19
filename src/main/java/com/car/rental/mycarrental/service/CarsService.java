package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarsService {
    public List<Car> getAllCars();

    public void saveCars(Car car);
}
