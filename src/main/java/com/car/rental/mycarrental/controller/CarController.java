package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Car;
import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.exception_handling.NoSuchCarException;
import com.car.rental.mycarrental.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
public class CarController {
    @Autowired
    private CarsService carsService;

    /*@CrossOrigin(origins = "*")
    @GetMapping("/cars")
    public List<Car> showAllCars() {
        List<Car> allCars = carsService.getAllCars();

//        List<Car> allCars = new ArrayList<>();
//        allCars.add(new Car("car1","eq1", 1, 1, 1));
//        allCars.add(new Car("car2","eq2", 1, 1, 2));
//        allCars.add(new Car("car3","eq3", 1, 1, 3));
        return allCars;
    }*/

//    @GetMapping("/cars")
//    public String showAllCars(Model model, @RequestParam(value="size", required = false, defaultValue = "0")Integer size,
//                              @RequestParam(value="page", required = false, defaultValue = "5")Integer page){
//       Page<Car> pageOfCars = carsService.gerAllCars(PageRequest.of(page, size));
//       model.addAttribute("carsPage", pageOfCars);
//       model.addAttribute("numbers", IntStream.range(0, pageOfCars.getTotalPages()).toArray());
//
//
//        return null;
//    }


//    @Value("${page}")
//    private int pageParam;
//
//    @Value("${limit}")
//    private int limitParam;
//
//    @GetMapping("/cars")
//    public ResponseEntity<Object> showAllCars(
//            @RequestParam(defaultValue = "0") Integer page,
//            @RequestParam(defaultValue = "5") Integer limit) {
//
//        try {
//            List<Car> cars = new ArrayList<>();
//            Pageable paging;
//            if (page == 0 && limit == 0) {
//                paging = PageRequest.of(pageParam, limitParam);
//            } else {
//                paging = PageRequest.of(page, limit);}
//
//                Page<Car> carsPage;
//                carsPage = carsService.findAll(paging);
//
//                cars = carsPage.getContent();
//                Map<String, Object> response = new HashMap<>();
//                response.put("cars", cars);
//                response.put("currentPage", carsPage.getNumber());
//                response.put("allItems", carsPage.getTotalElements());
//                response.put("allPages", carsPage.getTotalPages());
//                return ResponseEntity.ok().body(response);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }


   // }




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
    public Page<Car> showAllCars(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Car> allCars = carsService.findAll(offset, pageSize);

        return allCars;
    }

}
