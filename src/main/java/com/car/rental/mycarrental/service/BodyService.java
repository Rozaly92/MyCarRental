package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.entity.Body;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BodyService {
    List<Body> getBodies();
    Optional<Body> getBodyById(Integer id);
    Body saveBody(Body body);
    void updateBody(Body body, Integer id);
    void deleteBody(Integer id);

}
