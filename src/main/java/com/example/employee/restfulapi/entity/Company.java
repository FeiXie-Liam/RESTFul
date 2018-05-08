package com.example.employee.restfulapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIgnoreProperties(value="employees")
public class Company implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String companyName;
    private Integer employeesNumber;

    @OneToMany(mappedBy = "company",targetEntity = Employee.class,fetch = FetchType.LAZY)
//    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Set<Employee> employees = new HashSet<>();

    public Company() {
    }

    public Company(String companyName, Integer employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
