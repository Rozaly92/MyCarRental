package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> getAllCustomers();
}
