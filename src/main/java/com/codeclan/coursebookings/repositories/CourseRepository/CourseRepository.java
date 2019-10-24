package com.codeclan.coursebookings.repositories.CourseRepository;

import com.codeclan.coursebookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
