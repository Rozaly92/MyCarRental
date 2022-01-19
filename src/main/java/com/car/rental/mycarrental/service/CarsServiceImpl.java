package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.CarsDAO;
import com.car.rental.mycarrental.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarsDAO carsDAO;

    @Override
    @Transactional
    public List<Car> getAllCars() {
        return carsDAO.getAllCars();
    }

    @Override
    @Transactional
    public void saveCars(Car car) {
        carsDAO.saveCars(car);
    }



}

