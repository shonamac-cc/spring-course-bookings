package com.codeclan.coursebookings.repositories.CourseRepository;

import com.codeclan.coursebookings.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> findAllCoursesByCustomer(Long customerId);
}
