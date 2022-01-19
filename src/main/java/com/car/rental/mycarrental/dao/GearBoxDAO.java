package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.GearBox;

import java.util.List;

public interface GearBoxDAO {
    public List<GearBox> getAllGearBoxes();
    public void saveGearBox(GearBox gearBox);
}
