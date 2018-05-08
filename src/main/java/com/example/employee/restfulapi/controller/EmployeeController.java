package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="employees")
public class EmployeeController {
    //在此处完成Employee API
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/{id:[\\d]+}",method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeRepository.findById(id);
    }

    @RequestMapping(value = "/page/{page}/pageSize/{pageSize}",method = RequestMethod.GET)
    public Page<Employee> getEmployeesByCompanyId(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return employeeRepository.findAll(new PageRequest(page, pageSize));
    }

    @RequestMapping(value = "/{gender}", method = RequestMethod.GET)
    public List<Employee> getEmployeesByGender(@PathVariable("gender") String gender){
        return employeeRepository.findEmployeesByGenderIs(gender);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Employee> add(@RequestParam String name,
                              @RequestParam Integer age,
                              @RequestParam String gender,
                              @RequestParam Integer salary,
                              @RequestParam Long companyId){
        Employee employee = new Employee(name,age,gender,salary,companyId);
        employeeRepository.save(employee);
        return getEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Employee putCompany(@PathVariable Long id, @RequestParam(required = false) String name){
        employeeRepository.setNameFor(id, name);
        return employeeRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Employee> deleteCompanyById(@PathVariable Long id){
        employeeRepository.delete(id);
        return employeeRepository.findAll();
    }
}
