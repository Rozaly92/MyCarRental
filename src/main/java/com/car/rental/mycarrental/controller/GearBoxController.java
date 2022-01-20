package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.GearBox;
import com.car.rental.mycarrental.exception_handling.NoSuchGearBoxException;
import com.car.rental.mycarrental.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GearBoxController {

    @Autowired
    private GearBoxService gearBoxService;


    @GetMapping("/gearboxes")
    public List<GearBox> showGearBoxes() {
        List<GearBox> allGearboxes = gearBoxService.getAllGearBoxes();
        return allGearboxes;
    }

    @GetMapping("/gearboxes/{id}")
    public GearBox getGearBox(@PathVariable int id) {
        GearBox gearBox = gearBoxService.getGearBox(id);
        if (gearBox == null) {
            throw new NoSuchGearBoxException("There is no gearBox with id " +
                    id + " in database");
        }
        return gearBox;
    }

    @PostMapping("/gearboxes")
    public GearBox addNewGearBox(@RequestBody GearBox gearBox) {
        gearBoxService.saveGearBox(gearBox);
        return gearBox;
    }

    @PutMapping("/gearboxes")
    public GearBox updateGearBox(@RequestBody GearBox gearBox) {
        gearBoxService.saveGearBox(gearBox);
        return gearBox;
    }

    @DeleteMapping("/gearboxes/{id}")
    public String deleteGearBox(@PathVariable int id) {
        GearBox gearBox = gearBoxService.getGearBox(id);
        if (gearBox == null) {
            throw new NoSuchGearBoxException("There is no gearBox with id " +
                    id + " in database");
        }
        gearBoxService.deleteGearBox(id);
        return "GearBox with id = " + id + " was deleted!";
    }
}
