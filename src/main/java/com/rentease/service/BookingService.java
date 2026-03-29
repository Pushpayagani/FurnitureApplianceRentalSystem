package com.rentease.service;

import com.rentease.entity.BookingEntity;

import java.util.List;

public interface BookingService {

BookingEntity createBooking(BookingEntity booking);

List<BookingEntity> getBookingsByUserId(Long userId);
}
