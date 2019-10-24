package com.codeclan.coursebookings.repositories.CustomerRepository;

import com.codeclan.coursebookings.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> findCustomerByCourse(Long courseId);

    List<Customer>findCustomerByTownAndCourse(String town, Long CourseId);

    List<Customer> findCustomersOverCertainAgeByTownAndCourse(int age, String town, Long courseId);
}
