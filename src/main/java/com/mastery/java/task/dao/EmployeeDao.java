package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDao extends JpaRepository <Employee, Long>{

}
