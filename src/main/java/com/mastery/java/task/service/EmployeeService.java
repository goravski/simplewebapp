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

    public void addEmployee(Employee employee) {
        List<Employee> employeeList = getAllEmployees();
        if (!employeeList.contains(employee)) {
            employeeDao.save(employee);
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("This Employee is EXIST: " + employee.toString());

            }
        }
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = null;
        Optional<Employee> optional = employeeDao.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("No employee with id " + id);
            }
        }
        return employee;
    }

    public void deleteEmployeeById(Long id) {
        employeeDao.deleteById(id);
    }


}
