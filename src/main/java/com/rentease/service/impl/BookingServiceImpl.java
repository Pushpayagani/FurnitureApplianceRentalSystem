package com.rentease.service.impl;

import com.rentease.entity.BookingEntity;
import com.rentease.entity.ProductEntity;
import com.rentease.repository.BookingRepository;
import com.rentease.repository.ProductRepository;
import com.rentease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        booking.setStatus("BOOKED");
        Date startDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, 2);   // +2 days

        Date endDate = cal.getTime();

        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        Optional<ProductEntity> productEntity=productRepository.findById(booking.getProductId());
        double amountPerDay= productEntity.isPresent()?productEntity.get().getRentPerDay():0.0;
        booking.setTotalAmount(amountPerDay * 2); // Assuming 2 days rental
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

}
