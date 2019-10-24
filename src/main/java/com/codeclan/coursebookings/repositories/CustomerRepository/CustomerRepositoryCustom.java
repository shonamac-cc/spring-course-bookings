package com.codeclan.coursebookings.repositories.CustomerRepository;

import com.codeclan.coursebookings.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> findCustomerByCourse(Long courseId);
}
