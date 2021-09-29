package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService service;

    private final Employee baseEmployee = new Employee(1L, 5, "Test", "Testov", "jober",
            LocalDate.of(1900, 11, 11), Gender.FEMALE);

    @Before
    public void init() {
        service = new EmployeeService(employeeDao);
    }


    @Test
    void addEmployee() {
        Employee employeeForTest = new Employee(1L, 5, "Test2", "Testov2", "jober",
                LocalDate.of(1900, 11, 11), Gender.FEMALE);
        Mockito.when(employeeDao.save(employeeForTest)).thenReturn(employeeForTest);
        Employee actualEmployee = service.addEmployee(employeeForTest);

        Assertions.assertEquals(employeeForTest, actualEmployee);
    }

    @Test
    void addEmployeeFailTest() {
        Employee employeeForTest = new Employee(1L, 5, "Test", "Testov", "jober",
                LocalDate.of(1900, 11, 11), Gender.FEMALE);
        Mockito.when(employeeDao.findById(1L)).thenReturn(Optional.of(baseEmployee));
        Employee employeeresult = service.addEmployee(employeeForTest);

        Assertions.assertNull(employeeresult);
    }

    @Test
    void getAllEmployees() {
        List<Employee> employeesFromMock = new ArrayList<>();
        employeesFromMock.add(baseEmployee);
        Mockito.when(employeeDao.findAll()).thenReturn(employeesFromMock);
        List<Employee> employees = service.getAllEmployees();
        Assertions.assertEquals(employees, employeesFromMock);
    }

    @Test
    void getEmployeeById() {
        Long id = 1L;
        Mockito.when(employeeDao.findById(id)).thenReturn(Optional.of(baseEmployee));
        Employee actualEmployee = service.getEmployeeById(id);
        Assertions.assertEquals(baseEmployee, actualEmployee);
    }

}
