package com.rentease.controller;


import com.rentease.entity.BookingEntity;
import com.rentease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createBooking")
    public BookingEntity createBooking(@RequestBody BookingEntity booking){
        System.out.println("Received booking request: " + booking);
        return bookingService.createBooking(booking);
    }


    @GetMapping("/user/{userId}")
    public List<BookingEntity> getBookingsByUserId(@PathVariable Long userId){
        return bookingService.getBookingsByUserId(userId);
    }
}
