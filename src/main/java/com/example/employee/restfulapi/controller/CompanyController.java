package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/companies")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    //在此处完成Company API
    @RequestMapping(method = RequestMethod.GET)
    public List<Company> get(){
        return companyRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Company getCompanyById(@PathVariable("id") Long id){
        return companyRepository.findById(id);
    }

    @RequestMapping(value = "/{id}/employees",method = RequestMethod.GET)
    public List<Employee> getEmployeesByCompanyId(@PathVariable("id") Long id){
        return companyRepository.findById(id).getEmployees();
    }

    @RequestMapping(value = "/page/{page}/pageSize/{pageSize}",method = RequestMethod.GET)
    public Page<Company> getEmployeesByCompanyId(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return companyRepository.findAll(new PageRequest(page, pageSize));
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Company> add(@RequestParam String companyName,
                      @RequestParam Integer employeesNumber){
        Company company = new Company(companyName,employeesNumber);
        companyRepository.save(company);
        return get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Company putCompany(@PathVariable Long id, @RequestParam String companyName){
        companyRepository.setNameFor(companyName, id);
        return companyRepository.findById(id);
    }

}
