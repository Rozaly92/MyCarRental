package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarsService {
    public List<Car> getAllCars();
    public void saveCar(Car car);
    public Car getCar(int id);
    public void deleteCar(int id);
    Page<Car> findAll(int offset, int pageSize, String field);

    Page<Car> findAll(int offset, int pageSize);
}
