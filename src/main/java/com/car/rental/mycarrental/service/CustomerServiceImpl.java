package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.dao.CustomerRepository;
import com.car.rental.mycarrental.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
         customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
     Customer customer = null;
     Optional<Customer> newCustomer = customerRepository.findById(id);
     if(newCustomer.isPresent()){
         customer= newCustomer.get();
     }
     return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
