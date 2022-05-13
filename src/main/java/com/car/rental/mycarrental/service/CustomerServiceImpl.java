package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.dao.CustomerRepository;
import com.car.rental.mycarrental.entity.Car;
import com.car.rental.mycarrental.entity.Customer;
import com.car.rental.mycarrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
       if(!customerRepository.existsById(id))
           throw new NotFoundException(id);
       return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer, Integer id) {
        if(!customerRepository.existsById(id))
            throw new NotFoundException(id);

        Customer current = customerRepository.getById(id);
        current.updateCustomer(customer);
        customerRepository.save(current);
    }

    @Override
    public void deleteCustomer(Integer id) {
        if(!customerRepository.existsById(id))
            throw new NotFoundException(id);
        customerRepository.deleteById(id);
    }
}
