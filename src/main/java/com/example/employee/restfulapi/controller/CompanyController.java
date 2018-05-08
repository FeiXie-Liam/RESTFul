package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/companies")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    //在此处完成Company API
    @RequestMapping(method = RequestMethod.GET)
    List<Company> get(){
        return companyRepository.findAll();
    }
}
