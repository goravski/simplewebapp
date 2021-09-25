package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity <List<Employee>> showAll() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @PostMapping()
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployeeById(id);
        } catch (EmptyResultDataAccessException e) {
            e.getMessage();
            System.out.println("There is NO Employee with ID = " + id);
        }
        return "Operation DELETE was done";
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Employee employee = null;
        try {
            employee = employeeService.getEmployeeById(id);
        } catch (EmptyResultDataAccessException e) {
            e.getMessage();
            System.out.println("There is NO Employee with ID = " + id);
        }
        return employee;
    }

}
