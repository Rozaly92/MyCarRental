package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.dao.BodyDAO;
import com.car.rental.mycarrental.entity.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BodyServiceImpl implements BodyService {
    @Autowired
    private BodyDAO bodyDAO;

    @Override
    @Transactional
    public List<Body> getAllBodies() {
        return bodyDAO.getAllBodies();
    }

    @Override
    public void saveBody(Body body) {
        bodyDAO.saveBody(body);
    }


}
