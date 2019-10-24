package com.codeclan.coursebookings.repositories.CustomerRepository;

import com.codeclan.coursebookings.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> findCustomerByCourseIgnoreCase(Long courseId);

    List<Customer>findCustomerByTownAndCourseIgnoreCase(String town, Long CourseId);

    List<Customer> findCustomersOverCertainAgeByTownAndCourseIgnoreCase(int age, String town, Long courseId);
}
