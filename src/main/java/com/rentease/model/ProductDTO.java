package com.rentease.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private long id;

    private String name;
    private String description;
    private String category;
    private Double rentPerDay;
    private Boolean availabilityStatus;

}
