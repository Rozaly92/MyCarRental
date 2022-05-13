package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    List<Employee> getEmployees();
    Optional<Employee> getEmployeeById(Integer id);
    Employee saveEmployee(Employee employee);
    void updateEmployee(Employee employee, Integer id);
   void deleteEmployee(int id);
}
