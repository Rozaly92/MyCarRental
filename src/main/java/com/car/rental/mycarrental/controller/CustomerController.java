package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Customer;
import com.car.rental.mycarrental.exception_handling.NoSuchCustomerException;
import com.car.rental.mycarrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> showCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new NoSuchCustomerException("There is no customer with id " +
                    id + " in database");
        }
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new NoSuchCustomerException("There is no customer with id " +
                    id + " in database");
        }
        customerService.deleteCustomer(id);
        return "Customer with id = " + id + " was deleted!";
    }

}
