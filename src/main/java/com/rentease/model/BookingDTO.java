package com.rentease.model;


import lombok.*;

import java.util.Date;

//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {


    private String name;
    private Long userId;
    private Long productId;
    private Date startDate;
    private Date endDate;
    private Double totalAmount;
    private String status;

}
