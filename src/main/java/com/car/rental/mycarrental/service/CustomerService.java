package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Car;
import com.car.rental.mycarrental.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
List<Customer> getCustomers();
Optional<Customer> getCustomerById(Integer id);
Customer saveCustomer(Customer customer);
void updateCustomer(Customer customer, Integer id);
void deleteCustomer(Integer id);
}
