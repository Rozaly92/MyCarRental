package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@RestController
public class BodyController {
    @Autowired
    private BodyService bodyService;

    @GetMapping("/bodies")
    public ResponseEntity<Object> getBodies() {
        return ResponseEntity.ok().body(bodyService.getBodies());
    }

    @GetMapping("/bodies/{bodyId}")
    public ResponseEntity<Object> getBodyById(
            @PathVariable("bodyId") Integer bodyId){
        return ResponseEntity.ok().body(bodyService.getBodyById(bodyId));
    }

    @PostMapping("/bodies")
    public ResponseEntity<Object> addNewBody(@Valid @RequestBody Body body) {
        Body bodyy = bodyService.saveBody(body);
        try{
            return ResponseEntity
                    .created(new URI(String.format("/bodies/%s", bodyy)))
                    .build();
        } catch (URISyntaxException e) {
            throw new InternalServerException("The URI in the Location header in POST /bodies has an error");
        }
    }


    @PatchMapping("/bodies/{bodyId}")
    public ResponseEntity<Object> updateBody(@RequestBody Body body,
    @PathVariable("bodyId") Integer bodyId) {
        bodyService.updateBody(body, bodyId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bodies/{id}")
    public ResponseEntity<Object> deleteBody(@PathVariable("id") Integer id) {
        bodyService.deleteBody(id);
        return ResponseEntity.noContent().build();
    }

}
