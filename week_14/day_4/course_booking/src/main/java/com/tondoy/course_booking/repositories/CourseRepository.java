package com.tondoy.course_booking.repositories;

import com.tondoy.course_booking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findCoursesByStarRating(int rating);
    public List<Course> findAllByBookingsCustomerId(Long customerId);
}

