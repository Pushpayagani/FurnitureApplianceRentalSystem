package com.rentease.entity;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;
import org.springframework.stereotype.Repository;
import java.awt.image.BufferStrategy;
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    //private int stock;
}
