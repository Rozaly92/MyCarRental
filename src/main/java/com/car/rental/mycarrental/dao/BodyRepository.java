package com.car.rental.mycarrental.dao;


import com.car.rental.mycarrental.entity.Body;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BodyRepository extends JpaRepository<Body, Integer> {
    Optional<Body> findById(Integer id);
}
