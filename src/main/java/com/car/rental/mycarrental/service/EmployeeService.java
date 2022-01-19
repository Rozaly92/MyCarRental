package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getAllEmployees();
}
