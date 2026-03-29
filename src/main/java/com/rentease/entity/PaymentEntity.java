package com.rentease.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long bookingId;
    private Double amount;
    private String paymentStatus;
    private Date paymentDate;

}
