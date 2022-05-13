package com.car.rental.mycarrental.service;


import com.car.rental.mycarrental.dao.EmployeeRepository;
import com.car.rental.mycarrental.entity.Employee;
import com.car.rental.mycarrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
       if(!employeeRepository.existsById(id))
           throw new NotFoundException(id);
       return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee, Integer id) {
        if(!employeeRepository.existsById(id))
            throw new NotFoundException(id);

        Employee current = employeeRepository.getById(id);
        current.updateEmployee(employee);
        employeeRepository.save(current);
    }

    @Override
    public void deleteEmployee(int id) {
        if(!employeeRepository.existsById(id))
            throw new NotFoundException(id);
        employeeRepository.deleteById(id);
    }
}
