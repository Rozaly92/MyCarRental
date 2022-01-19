package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Fuel;

import java.util.List;

public interface FuelDAO {
    public List<Fuel> getAllFuels();
    public void saveFuel(Fuel fuel);
}
