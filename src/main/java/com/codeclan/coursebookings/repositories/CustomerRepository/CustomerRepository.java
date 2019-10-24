package com.codeclan.coursebookings.repositories.CustomerRepository;

import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.projections.EmbedCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbedCourse.class)
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

}
