package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.GearBox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GearBoxService {
    public List<GearBox> getAllGearBoxes();
    public void saveGearBox(GearBox gearBox);
    public GearBox getGearBox(int id);
    public void deleteGearBox(int id);
}
