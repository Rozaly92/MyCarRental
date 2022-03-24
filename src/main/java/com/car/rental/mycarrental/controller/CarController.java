package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Car;
import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.exception_handling.NoSuchCarException;
import com.car.rental.mycarrental.service.CarsService;
import com.car.rental.mycarrental.service.CarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarsService carsService;

    @Autowired
    private CarsServiceImpl carsServiceImpl;

   // @CrossOrigin(origins = "*")
    @GetMapping("/cars")
    public List<Car> showAllCars(){
        List<Car> allCars = carsService.getAllCars();
        return allCars;
    }


    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable int id) {
        Car car = carsService.getCar(id);
        if (car == null) {
            throw new NoSuchCarException("There is no car with id " +
                    id + " in database");
        }
        return car;

    }

    @PostMapping("/cars")
    public Car addNewCar(@RequestBody Car car) {
        Car carToSave = new Car();
        carToSave = car;
        if (car.getFuel().equals("benzin")) {
            Fuel benzinFuel = car.getFuel();
            benzinFuel.setId(1);
            carToSave.setFuel(benzinFuel);
        }
        carsService.saveCar(carToSave);
        return carToSave;
    }


    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car car) {
        carsService.saveCar(car);
        return car;
    }


    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable int id) {
        Car car = carsService.getCar(id);
        if (car == null) {
            throw new NoSuchCarException("There is no car with id " +
                    id + " in database");
        }
        return "Car with id = " + id + " was deleted!";
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
