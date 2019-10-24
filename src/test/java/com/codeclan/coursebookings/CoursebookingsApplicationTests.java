package com.codeclan.coursebookings;

import com.codeclan.coursebookings.models.Booking;
import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.repositories.BookingRepository.BookingRepository;
import com.codeclan.coursebookings.repositories.CourseRepository.CourseRepository;
import com.codeclan.coursebookings.repositories.CustomerRepository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingsApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByStarRating(){
		List<Course> foundCourses = courseRepository.findByStarRating(4);
		assertEquals(2, foundCourses.size());
	}

	@Test
	public void canGetBookingsByDate(){
		List<Booking> foundBookings = bookingRepository.findByDate("01-01-01");
		assertEquals(2, foundBookings.size());
	}

	@Test
	public void canFindAllCustomersByCourse(){
		List<Customer> foundCustomers = customerRepository.findCustomerByCourseIgnoreCase(1L);
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canFindAllCoursesByCustomer(){
		List<Course> foundCourses = courseRepository.findAllCoursesByCustomer(1L);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canFindCustomersByTownAndCourse(){
		List<Customer> foundCustomers = customerRepository.findCustomerByTownAndCourseIgnoreCase("Edinburgh", 1L);
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canFindCustomersByAgeAndCourse(){
		List<Customer> foundCustomers = customerRepository.findCustomersOverCertainAgeByTownAndCourseIgnoreCase(55, "Edinburgh", 1L);
		assertEquals(1, foundCustomers.size());
	}
}
