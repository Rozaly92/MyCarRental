package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.entity.Employee;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(
            @PathVariable("id") Integer id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addNewEmployee(@Valid @RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);
        try{
            return ResponseEntity
                    .created(new URI(String.format("/employees/%s", newEmployee.getEmpId())))
                    .build();
        } catch (URISyntaxException e) {
//            throw new InternalServerException("The URI in the Location header in POST /employees has an error");
           e.printStackTrace();
        }
        return null;
    }


    @PatchMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee,
                                             @PathVariable("id") Integer id) {
        employeeService.updateEmployee(employee,id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
