package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
