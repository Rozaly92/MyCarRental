package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.FuelRepository;
import com.car.rental.mycarrental.entity.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelServiceImpl implements FuelService {
    @Autowired
    private FuelRepository fuelRepository;


    @Override
    public List<Fuel> getAllFuels() {
        return fuelRepository.findAll();
    }

    @Override
    public void saveFuel(Fuel fuel) {
fuelRepository.save(fuel);
    }

    @Override
    public Fuel getFuel(int id) {
       Fuel fuel = null;
        Optional<Fuel> newFuel = fuelRepository.findById(id);
        if(newFuel.isPresent()){
            fuel = newFuel.get();
        }
        return fuel;
    }

    @Override
    public void deleteFuel(int id) {
        fuelRepository.deleteById(id);
    }
}
