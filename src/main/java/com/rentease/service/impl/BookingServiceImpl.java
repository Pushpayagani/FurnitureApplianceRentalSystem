package com.rentease.service.impl;

import com.rentease.entity.BookingEntity;
import com.rentease.repository.BookingRepository;
import com.rentease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        booking.setStatus("BOOKED");
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

}
