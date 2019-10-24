package com.codeclan.coursebookings.repositories.CustomerRepository;

import com.codeclan.coursebookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
