package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
}
