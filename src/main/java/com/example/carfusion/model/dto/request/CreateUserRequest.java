package com.example.carfusion.model.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    String name;

    String surname;

    String email;

    String phoneNumber;

    String password;

}
