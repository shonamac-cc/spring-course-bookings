package com.codeclan.coursebookings.controllers;

import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{courseId}")
    public List<Customer> findCustomerByCourse(@PathVariable Long courseId){
        return customerRepository.findCustomerByCourse(courseId);
    }

    @GetMapping(value = "/courseandtown/{town}/{courseId}")
    public List<Customer>findCustomerByTownAndCourse(@PathVariable String town,@PathVariable Long courseId){
        return customerRepository.findCustomerByTownAndCourse(town, courseId);
    }
}
