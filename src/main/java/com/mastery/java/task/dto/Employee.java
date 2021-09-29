package com.mastery.java.task.dto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "date_of_birth")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Employee() {
    }

    public Employee(Long employeeId, Integer departmentId, String firstName, String lastname, String jobTitle, LocalDate dateOfBirth, Gender gender) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.jobTitle = jobTitle;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getDepartmentId(), employee.getDepartmentId())
                && Objects.equals(getFirstName(), employee.getFirstName())
                && Objects.equals(getLastname(), employee.getLastname())
                && Objects.equals(getJobTitle(), employee.getJobTitle())
                && Objects.equals(getDateOfBirth(), employee.getDateOfBirth())
                && Objects.equals(getGender(), employee.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDepartmentId(), getFirstName(), getLastname(), getJobTitle(), getDateOfBirth(), getGender());
    }

    @Override
    public String toString() {
        return "Employee{" +
                " departmentId=" + departmentId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
