package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.CarRepository;
import com.car.rental.mycarrental.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<Car> findAll(int offset, int pageSize, String field) {
        return null;
    }
//
//    @Override
//    public Page<Car> findAll(Pageable pageable) {
//        return carRepository.findAll(pageable);
//    }


    @Override
    public Page<Car> findAll(int offset, int pageSize) {
        Page<Car> allCars = carRepository.findAll(PageRequest.of(offset, pageSize));

        return allCars;
    }


    public Page<Car> findAllWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Car> allCars = carRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));

        return allCars;
    }

    public Page<Car> findAllWithPaginationAndSortingInDescendingOrder(int offset, int pageSize, String field) {
        Page<Car> allCars = carRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.DESC, field));

        return allCars;
    }
}

