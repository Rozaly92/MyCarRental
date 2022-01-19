package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Fuel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuelService {

    public List<Fuel> getAllFuels();
    public void saveFuel(Fuel fuel);
}
