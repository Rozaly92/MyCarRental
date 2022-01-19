package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.FuelDAO;
import com.car.rental.mycarrental.entity.Fuel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FuelServiceImpl implements FuelService {
    @Autowired
    private FuelDAO fuelDAO;

    @Override
    @Transactional
    public List<Fuel> getAllFuels() {
        return fuelDAO.getAllFuels();
    }

    @Override
    @Transactional
    public void saveFuel(Fuel fuel) {
        fuelDAO.saveFuel(fuel);
    }
}
