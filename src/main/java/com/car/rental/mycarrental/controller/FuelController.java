package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Employee;
import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FuelController {
    @Autowired
    private FuelService fuelService;


    @GetMapping("/fuels")
    public ResponseEntity<Object> getFuels() {
        return ResponseEntity.ok().body(fuelService.getFuels());
    }

    @GetMapping("/fuels/{id}")
    public ResponseEntity<Object> getFuelById(
            @PathVariable("id") Integer id){
        return ResponseEntity.ok().body(fuelService.getFuelById(id));
    }

    @PostMapping("/fuels")
    public ResponseEntity<Object> addNewFuel(@Valid @RequestBody Fuel fuel) {
        Fuel newFuel = fuelService.saveFuel(fuel);
        try{
            return ResponseEntity
                    .created(new URI(String.format("/fuels/%s", newFuel)))
                    .build();
        } catch (URISyntaxException e) {
            throw new InternalServerException("The URI in the Location header in POST /fuels has an error");
        }
    }


    @PatchMapping("/fuels/{id}")
    public ResponseEntity<Object> updateFuel(@RequestBody Fuel fuel,
                                                 @PathVariable("id") Integer id) {
        fuelService.updateFuel(fuel, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/fuels/{id}")
    public ResponseEntity<Object> deleteFuel(@PathVariable("id") Integer id) {
        fuelService.deleteFuel(id);
        return ResponseEntity.noContent().build();
    }

}
