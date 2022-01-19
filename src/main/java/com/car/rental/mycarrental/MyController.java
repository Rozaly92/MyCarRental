package com.car.rental.mycarrental;

import com.car.rental.mycarrental.entity.*;
import com.car.rental.mycarrental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("/allfuels")
    public String showFuels(Model model) {
        List<Fuel> allFuels = fuelService.getAllFuels();
        model.addAttribute("fuels", allFuels);
        return "show-fuels";
    }

    @RequestMapping("/allcars")
    public String showCars(Model model) {
        List<Car> allCars = carsService.getAllCars();
        model.addAttribute("cars", allCars);
        return "";
    }

    @RequestMapping("/allcustomers")
    public String showCustomers(Model model) {
        List<Customer> allCustomers = customerService.getAllCustomers();
        model.addAttribute("customers", allCustomers);
        return "show-customers";
    }

    @RequestMapping("/allbodies")
    public String showBodies(Model model) {
        List<Body> allBodies = bodyService.getAllBodies();
        model.addAttribute("bodies", allBodies);
        return "show-bodies";
    }

    @RequestMapping("/allemployees")
    public String showEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        return "show-employees";
    }

    @RequestMapping("/allgearboxes")
    public String showGearBoxes(Model model) {
        List<GearBox> allGearboxes = gearBoxService.getAllGearBoxes();
        model.addAttribute("gearBoxes", allGearboxes);
        return "show-gearBoxes";
    }

    @RequestMapping("/allOrders")
    public String showOrders(Model model) {
        List<Orders> allOrders = ordersService.getAllOrders();
        model.addAttribute("orders", allOrders);
        return "show-orders";
    }

    @RequestMapping("/addNewCar")
    public String addNewCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "show-cars";
        /// return "add-car";
    }

    @RequestMapping("/saveCar")
    public String saveEmployee(@ModelAttribute("car") Car car) {
        carsService.saveCars(car);

        return "redirect:/";
    }
}
