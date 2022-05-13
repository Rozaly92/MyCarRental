package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.entity.Customer;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<Object> getCustomers() {

        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }
    @PostMapping("/customers")
    public ResponseEntity<Object> addNewCustomer(@Valid @RequestBody Customer customer) {
       Customer newCustomer = customerService.saveCustomer(customer);
       try{
           return ResponseEntity
                   .created(new URI(String.format("/customers/%s", newCustomer)))
                   .build();
       }catch(URISyntaxException e){
           throw new InternalServerException("The URI in the Location header in POST /customers has an error");
       }
    }

    @PatchMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,
                                             @PathVariable("id") Integer id) {
       customerService.updateCustomer(customer, id);
        return ResponseEntity.noContent().build();
    }




    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Object>  deleteCustomer(@PathVariable("id") Integer id) {

        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
