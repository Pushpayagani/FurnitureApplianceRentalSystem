package com.rentease.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {

    private long id;

    private long bookingId;
    private Double amount;
    private String paymentStatus;
    private Data paymentDate;

}
