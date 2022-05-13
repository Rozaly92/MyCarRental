package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.GearBox;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GearBoxService {
    List<GearBox> getGearBoxes();
    Optional<GearBox> getGearBoxById(Integer id);
    GearBox saveGearBox(GearBox gearBox);
    void updateGearBox(GearBox gearBox, Integer id);
    void deleteGearBox(Integer id);

}
