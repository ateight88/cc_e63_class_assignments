package com.tondoy.course_booking.repositories;

import com.tondoy.course_booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findAllByBookingsCourseId(Long courseId);
    public List<Customer> findAllByTownAndBookingsCourseId(String town, Long courseId);
    public List<Customer> findAllByTownAndAgeGreaterThanAndBookingsCourseId(String town, int age, Long courseId);

}
