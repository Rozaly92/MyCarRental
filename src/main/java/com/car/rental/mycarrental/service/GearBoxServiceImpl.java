package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.GearBoxRepository;
import com.car.rental.mycarrental.entity.GearBox;
import com.car.rental.mycarrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GearBoxServiceImpl implements GearBoxService {
    @Autowired
    private GearBoxRepository gearBoxRepository;


    @Override
    public List<GearBox> getGearBoxes() {
        return gearBoxRepository.findAll();
    }

    @Override
    public Optional<GearBox> getGearBoxById(Integer id) {
        if(!gearBoxRepository.existsById(id))
            throw new NotFoundException(id);
        return gearBoxRepository.findById(id);
    }

    @Override
    public GearBox saveGearBox(GearBox gearBox) {
        return gearBoxRepository.save(gearBox);
    }

    @Override
    public void updateGearBox(GearBox gearBox, Integer id) {
        if(!gearBoxRepository.existsById(id))
            throw new NotFoundException(id);

        GearBox current = gearBoxRepository.getById(id);
        current.updateGearBox(gearBox);
        gearBoxRepository.save(current);
    }

    @Override
    public void deleteGearBox(Integer id) {
        if(!gearBoxRepository.existsById(id))
            throw new NotFoundException(id);
        gearBoxRepository.deleteById(id);
    }
}
