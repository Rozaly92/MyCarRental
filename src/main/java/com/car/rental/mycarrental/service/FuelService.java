package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Fuel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FuelService {

    List<Fuel> getFuels();
    Optional<Fuel> getFuelById(Integer id);
    Fuel saveFuel(Fuel fuel);
    void updateFuel(Fuel fuel, Integer id);
     void deleteFuel(Integer id);
}
