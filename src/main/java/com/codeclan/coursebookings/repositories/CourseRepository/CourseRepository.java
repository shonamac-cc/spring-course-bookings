package com.codeclan.coursebookings.repositories.CourseRepository;

import com.codeclan.coursebookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
    List<Course> findByStarRating(int starRating);

}
