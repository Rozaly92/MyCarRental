package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Car;
import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.CarsService;
import com.car.rental.mycarrental.service.CarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarsService carsService;

    @Autowired
    private CarsServiceImpl carsServiceImpl;

   // @CrossOrigin(origins = "*")
    @GetMapping("/cars")
    public ResponseEntity<Object> getCars(){
       return ResponseEntity.ok().body(carsService.getCars());
    }

    @GetMapping("/cars/{carId}")
    public ResponseEntity<Object> getCarById(
            @PathVariable("carId") Integer carId){
        return ResponseEntity.ok().body(carsService.getCarById(carId));
    }

    @PostMapping("/cars")
    public ResponseEntity<Object> addNewCar(@Valid @RequestBody Car car){
        Car newCar= carsService.saveCar(car);
        try{
            return ResponseEntity
                    .created(new URI(String.format("/cars/%s", newCar)))
                    .build();
        }catch (URISyntaxException e){
            throw new InternalServerException("The URI in the Location header in POST /cars has an error");
        }
    }

    @PatchMapping("/cars/{carId}")
    public ResponseEntity<Object> updateCar(@RequestBody Car car,
                                            @PathVariable("carId") Integer carId){
        carsService.updateCar(car, carId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable("id")Integer id){
        carsService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }




    @GetMapping("/cars/{offset}/{pageSize}")
    public Page<Car> showAllCarsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Car> allCars = carsService.findAll(offset, pageSize);

        return allCars;
    }


    @GetMapping("/cars/{offset}/{pageSize}/{field}")
    public Page<Car> showAllCarsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Car> allCars = carsServiceImpl.findAllWithPaginationAndSorting(offset, pageSize, field);

        return allCars;
    }

    @GetMapping("/cars/desc/{offset}/{pageSize}/{field}")
    public Page<Car> showAllCarsWithPaginationAndSortInDescOrder(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Car> allCars = carsServiceImpl.findAllWithPaginationAndSortingInDescendingOrder(offset, pageSize, field);

        return allCars;
    }
}
