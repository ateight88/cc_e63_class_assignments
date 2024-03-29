package com.tondoy.course_booking.components;

import com.tondoy.course_booking.models.Booking;
import com.tondoy.course_booking.models.Course;
import com.tondoy.course_booking.models.Customer;
import com.tondoy.course_booking.repositories.BookingRepository;
import com.tondoy.course_booking.repositories.CourseRepository;
import com.tondoy.course_booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Intro To Python", "Glasgow",5);
        courseRepository.save(course1);

        Course course2 = new Course("JavaScript for beginners", "Edinburgh",4);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Bob", "Modena", 30);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jeff", "Novato", 41);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Jackie", "San Francisco", 40);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Eric", "Novato", 55);
        customerRepository.save(customer4);

        // Bob booked Python on xmas eve
        Booking booking1 = new Booking("24-12-2018", customer1, course1);
        bookingRepository.save(booking1);

        // jeff booked Javascript on xmas eve
        Booking booking2 = new Booking("24-12-2018", customer2, course2);
        bookingRepository.save(booking2);

        // Jackie booked javascript on 17th November
        Booking booking3 = new Booking("17-11-2019", customer3, course2);
        bookingRepository.save(booking3);

        //Eric booked javascript on xmas eve
        Booking booking4  = new Booking("24-12-2018", customer4, course2);
        bookingRepository.save(booking4);

    }
}