package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.GearBoxDAO;
import com.car.rental.mycarrental.entity.GearBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GearBoxServiceImpl implements GearBoxService {
    @Autowired
    private GearBoxDAO gearBoxDAO;

    @Override
    @Transactional
    public List<GearBox> getAllGearBoxes() {
        return gearBoxDAO.getAllGearBoxes();
    }

    @Override
    @Transactional
    public void saveGearBox(GearBox gearBox) {
        gearBoxDAO.saveGearBox(gearBox);
    }
}
