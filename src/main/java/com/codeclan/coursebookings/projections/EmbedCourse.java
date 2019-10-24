package com.codeclan.coursebookings.projections;

import com.codeclan.coursebookings.models.Booking;
import com.codeclan.coursebookings.models.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "EmbedCourse", types = Booking.class)
public interface EmbedCourse {


}
