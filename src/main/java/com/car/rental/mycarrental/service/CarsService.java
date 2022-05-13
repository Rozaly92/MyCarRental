package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public interface CarsService {
    List<Car> getCars();
    Optional<Car> getCarById(Integer id);
    Car saveCar(Car car);
    void updateCar(Car car, Integer id);
    void deleteCar(Integer id);


    Page<Car> findAll(int offset, int pageSize, String field);

    Page<Car> findAll(int offset, int pageSize);
}
