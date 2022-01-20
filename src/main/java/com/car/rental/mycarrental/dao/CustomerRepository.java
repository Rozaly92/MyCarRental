package com.car.rental.mycarrental.dao;


import com.car.rental.mycarrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
