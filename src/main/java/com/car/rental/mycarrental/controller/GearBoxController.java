package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Employee;
import com.car.rental.mycarrental.entity.GearBox;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class GearBoxController {

    @Autowired
    private GearBoxService gearBoxService;

    @GetMapping("/gear-boxes")
    public ResponseEntity<Object> getGearBoxes() {
        return ResponseEntity.ok().body(gearBoxService.getGearBoxes());
    }

    @GetMapping("/gear-boxes/{id}")
    public ResponseEntity<Object> getGearBoxById(
            @PathVariable("id") Integer id){
        return ResponseEntity.ok().body(gearBoxService.getGearBoxById(id));
    }

    @PostMapping("/gear-boxes")
    public ResponseEntity<Object> addNewGearBox(@Valid @RequestBody GearBox gearBox) {
        GearBox newGearBox = gearBoxService.saveGearBox(gearBox);
        try{
            return ResponseEntity
                    .created(new URI(String.format("/gear-boxes/%s", newGearBox)))
                    .build();
        } catch (URISyntaxException e) {
            throw new InternalServerException("The URI in the Location header in POST /gear-boxes has an error");
        }
    }


    @PatchMapping("/gear-boxes/{id}")
    public ResponseEntity<Object> updateGearBox(@RequestBody GearBox gearBox,
                                                 @PathVariable("id") Integer id) {
        gearBoxService.updateGearBox(gearBox, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/gear-boxes/{id}")
    public ResponseEntity<Object> deleteGearBox(@PathVariable("id") Integer id) {
        gearBoxService.deleteGearBox(id);
        return ResponseEntity.noContent().build();
    }
}
