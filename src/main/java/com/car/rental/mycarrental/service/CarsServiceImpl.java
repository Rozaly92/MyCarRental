package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.CarRepository;
import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getCar(int id) {
        Car car= null;
        Optional<Car> newCar = carRepository.findById(id);
        if(newCar.isPresent()){
            car = newCar.get();
        }
        return car;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }


}

