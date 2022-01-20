package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.*;
import com.car.rental.mycarrental.exception_handling.FuelIncorrectData;
import com.car.rental.mycarrental.exception_handling.NoSuchFuelException;
import com.car.rental.mycarrental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private FuelService fuelService;

    @Autowired
    private CarsService carsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BodyService bodyService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GearBoxService gearBoxService;

    @Autowired
    private OrdersService ordersService;


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

    @GetMapping("/cars")
    public List<Car> showAllCars() {
        List<Car> allCars = carsService.getAllCars();
        return allCars;
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable int id) {
        Car car = carsService.getCar(id);
        return car;

    }

    @PostMapping("/cars")
    public Car addNewCar(@RequestBody Car car) {
        carsService.saveCar(car);
        return car;
    }


    @GetMapping("/customers")
    public List<Customer> showCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        return customer;
    }

    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

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
        return body;
    }


    @GetMapping("/employees")
    public List<Employee> showEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @GetMapping("/gearboxes")
    public List<GearBox> showGearBoxes() {
        List<GearBox> allGearboxes = gearBoxService.getAllGearBoxes();
        return allGearboxes;
    }

    @GetMapping("/gearboxes/{id}")
    public GearBox getGearBox(@PathVariable int id) {
        GearBox gearBox = gearBoxService.getGearBox(id);
        return gearBox;
    }

    @PostMapping("/gearboxes")
    public GearBox addNewGearBox(@RequestBody GearBox gearBox) {
        gearBoxService.saveGearBox(gearBox);
        return gearBox;
    }


    @GetMapping("/orders")
    public List<Order> showOrders() {
        List<Order> allOrders = ordersService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = ordersService.getOrder(id);
        return order;
    }

    @PostMapping("/orders")
    public Order addNewOrder(@RequestBody Order order) {
        ordersService.saveOrder(order);
        return order;
    }

    @ExceptionHandler
    public ResponseEntity<FuelIncorrectData> handleException(NoSuchFuelException exception){
        FuelIncorrectData fuelIncorrectData = new FuelIncorrectData();
        fuelIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(fuelIncorrectData, HttpStatus.NOT_FOUND);


    }







}
