package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.FuelRepository;
import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelServiceImpl implements FuelService {
    @Autowired
    private FuelRepository fuelRepository;


    @Override
    public List<Fuel> getFuels() {
        return fuelRepository.findAll();
    }

    @Override
    public Optional<Fuel> getFuelById(Integer id) {
       if(!fuelRepository.existsById(id))
           throw new NotFoundException(id);
       return fuelRepository.findById(id);
    }

    @Override
    public Fuel saveFuel(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    @Override
    public void updateFuel(Fuel fuel, Integer id) {
        if(!fuelRepository.existsById(id))
            throw new NotFoundException(id);

        Fuel current = fuelRepository.getById(id);
        current.updateFuel(fuel);
        fuelRepository.save(current);
    }

    @Override
    public void deleteFuel(Integer id) {
        if(!fuelRepository.existsById(id))
            throw new NotFoundException(id);
        fuelRepository.deleteById(id);
    }
}
