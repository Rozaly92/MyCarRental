package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Car;

import java.util.List;

public interface CarsDAO {
    public List<Car> getAllCars();

    public void saveCars(Car car);
}
