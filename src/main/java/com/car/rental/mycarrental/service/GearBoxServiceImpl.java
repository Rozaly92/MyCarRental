package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.GearBoxRepository;
import com.car.rental.mycarrental.entity.GearBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GearBoxServiceImpl implements GearBoxService {
    @Autowired
    private GearBoxRepository gearBoxRepository;


    @Override
    public List<GearBox> getAllGearBoxes() {
        return gearBoxRepository.findAll();
    }

    @Override
    public void saveGearBox(GearBox gearBox) {
        gearBoxRepository.save(gearBox);
    }

    @Override
    public GearBox getGearBox(int id) {
       GearBox gearBox = null;
        Optional<GearBox> newGearBox = gearBoxRepository.findById(id);
        if(newGearBox.isPresent()){
            gearBox = newGearBox.get();
        }
        return gearBox;
    }

    @Override
    public void deleteGearBox(int id) {
        gearBoxRepository.deleteById(id);
    }
}
