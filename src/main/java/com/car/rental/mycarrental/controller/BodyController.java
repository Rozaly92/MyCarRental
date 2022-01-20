package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.exception_handling.NoSuchBodyException;
import com.car.rental.mycarrental.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BodyController {
    @Autowired
    private BodyService bodyService;

    @GetMapping("/bodies")
    public List<Body> showBodies() {
        List<Body> allBodies = bodyService.getAllBodies();
        return allBodies;
    }

    @PostMapping("/bodies")
    public Body addNewBody(@RequestBody Body body) {
        bodyService.saveBody(body);
        return body;
    }

    @GetMapping("/bodies/{id}")
    public Body getBody(@PathVariable int id) {
        Body body = bodyService.getBody(id);
        if (body == null) {
            throw new NoSuchBodyException("There is no body with id " +
                    id + " in database");
        }
        return body;
    }

    @PutMapping("/bodies")
    public Body updateBody(@RequestBody Body body) {
        bodyService.saveBody(body);
        return body;
    }


    @DeleteMapping("/bodies/{id}")
    public String deleteBody(@PathVariable int id) {
        Body body = bodyService.getBody(id);
        if (body == null) {
            throw new NoSuchBodyException("There is no body with id " +
                    id + " in database");
        }
        bodyService.deleteBody(id);
        return "Body with id = " + id + " was deleted!";
    }


}
