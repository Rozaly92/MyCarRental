package com.car.rental.mycarrental.dao;


import com.car.rental.mycarrental.entity.Body;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyRepository extends JpaRepository<Body, Integer> {
}
