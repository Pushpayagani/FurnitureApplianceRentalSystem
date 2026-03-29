package com.rentease.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private String userId;

    private String name;
    private String email;
    private String password;
    private String phone;

}
