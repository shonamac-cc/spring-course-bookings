package com.codeclan.coursebookings.components;

import com.codeclan.coursebookings.models.Booking;
import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.repositories.BookingRepository.BookingRepository;
import com.codeclan.coursebookings.repositories.CourseRepository.CourseRepository;
import com.codeclan.coursebookings.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Java", "Edinburgh", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Ruby", "Edinburgh", 4);
        courseRepository.save(course2);

        Course course3 = new Course("Javascript", "Edinburgh", 3);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Jordan", "Edinburgh", 84);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Alex", "Edinburgh", 54);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Shona", "Edinburgh", 97);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("01/01/01", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01/01/01", customer2, course1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01/02/01", customer3, course2);
        bookingRepository.save(booking3);
    }
}
