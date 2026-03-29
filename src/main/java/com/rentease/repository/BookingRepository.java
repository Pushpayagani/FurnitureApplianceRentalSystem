package com.rentease.repository;

import com.rentease.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {


    List<BookingEntity> findByUserId(Long userId);
}
