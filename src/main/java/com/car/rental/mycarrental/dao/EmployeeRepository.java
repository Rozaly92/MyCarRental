package com.car.rental.mycarrental.dao;


import com.car.rental.mycarrental.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
