package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {

        this.employeeDao = employeeDao;
    }


    public List<Employee> getAllEmployees() {

        return employeeDao.findAll();
    }

    public Employee addEmployee(Employee employee) {
        List<Employee> employeeList = getAllEmployees();
        Employee employeeNew = new Employee();
        if (!employeeList.contains(employee)) {
            employeeNew = employeeDao.save(employee);
        } else {
            System.out.println("This Employee is EXIST: " + employee.toString());
        }
        return employeeNew;
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = null;
        Optional<Employee> optional = employeeDao.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        }
        return employee;
    }

    public void deleteEmployeeById(Long id) {
        employeeDao.deleteById(id);
    }


}
