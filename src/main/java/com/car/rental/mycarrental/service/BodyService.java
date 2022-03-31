package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.entity.Body;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BodyService {
    public List<Body> getAllBodies();
    public void saveBody(Body body);
    public Body getBody(int id);
    public void deleteBody(Integer id);
}
