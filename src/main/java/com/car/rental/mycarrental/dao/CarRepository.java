package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    //Page<Car> findAll(Pageable pageable);


}
