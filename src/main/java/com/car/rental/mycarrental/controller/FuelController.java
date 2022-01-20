package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.exception_handling.NoSuchFuelException;
import com.car.rental.mycarrental.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuelController {
    @Autowired
    private FuelService fuelService;

    @RequestMapping("/fuels")
    public List<Fuel> showFuels() {
        List<Fuel> allFuels = fuelService.getAllFuels();
        return allFuels;
    }

    @PostMapping("/fuels")
    public Fuel addNewFuel(@RequestBody Fuel fuel) {
        fuelService.saveFuel(fuel);
        return fuel;
    }

    @GetMapping("/fuels/{id}")
    public Fuel getFuel(@PathVariable int id) {
        Fuel fuel = fuelService.getFuel(id);
        if (fuel == null) {
            throw new NoSuchFuelException("There is no fuel with ID = " + id + " in database");
        }
        return fuel;
    }

    @DeleteMapping("/fuels/{id}")
    public String deleteFuel(@PathVariable int id) {
        Fuel fuel = fuelService.getFuel(id);
        if (fuel == null) {
            throw new NoSuchFuelException("There is no fuel with ID = " + id + " in database");
        }
        fuelService.deleteFuel(id);
        return "Fuel with id = " + id + " was deleted!";
    }

    @PutMapping("/fuels")
    public Fuel updateFuel(@RequestBody Fuel fuel) {
        fuelService.saveFuel(fuel);
        return fuel;
    }

}
