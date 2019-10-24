package com.codeclan.coursebookings.repositories.BookingRepository;

import com.codeclan.coursebookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(String date);
}
