package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.dao.BodyRepository;
import com.car.rental.mycarrental.entity.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyServiceImpl implements BodyService {
    @Autowired
    private BodyRepository bodyRepository;


    @Override
    public List<Body> getAllBodies() {

        return bodyRepository.findAll();
    }

    @Override
    public void saveBody(Body body) {
        bodyRepository.save(body);
    }

    @Override
    public Body getBody(int id) {
        Body body = null;
        Optional<Body> newbody = bodyRepository.findById(id);
        if (newbody.isPresent()) {
            body = newbody.get();
        }
        return body;
    }

    @Override
    public void deleteBody(Integer id) {
        bodyRepository.deleteById(id);
    }
}
