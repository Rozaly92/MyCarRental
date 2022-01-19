package com.car.rental.mycarrental.dao;


import com.car.rental.mycarrental.entity.Body;

import java.util.List;

public interface BodyDAO {
    public List<Body> getAllBodies();
    public void saveBody(Body body);
}
