package com.codeclan.coursebookings.controllers;

import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{starRating}")
    public List<Course> findByStarRating(@PathVariable int starRating){
        return courseRepository.findByStarRating(starRating);
    }

    @GetMapping(value = "/customers/{customerId}")
    public List<Course> findAllCoursesByCustomer(@PathVariable Long customerId){
        return courseRepository.findAllCoursesByCustomer(customerId);
    }
}
