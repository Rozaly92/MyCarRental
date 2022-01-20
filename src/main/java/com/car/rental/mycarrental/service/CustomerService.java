package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> getAllCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
}
