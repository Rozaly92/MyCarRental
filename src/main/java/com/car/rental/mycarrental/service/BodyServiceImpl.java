package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.dao.BodyRepository;
import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyServiceImpl implements BodyService {
    @Autowired
    private BodyRepository bodyRepository;


    @Override
    public List<Body> getBodies() {
        return bodyRepository.findAll();
    }

    @Override
    public Optional<Body> getBodyById(Integer id) {
        if(!bodyRepository.existsById(id))
            throw new NotFoundException(id);
        return bodyRepository.findById(id);
    }

    @Override
    public Body saveBody(Body body) { return bodyRepository.save(body);
    }

    @Override
    public void updateBody(Body body, Integer id) {
        if(!bodyRepository.existsById(id))
            throw new NotFoundException(id);

        Body current = bodyRepository.getById(id);
        current.updateBody(body);
        bodyRepository.save(current);
    }


    @Override
    public void deleteBody(Integer id) {
        if(!bodyRepository.existsById(id))
            throw new NotFoundException(id);
        bodyRepository.deleteById(id);
    }
}
