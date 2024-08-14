package com.example.carfusion.model.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank
    String name;
    @NotBlank
    String surname;
    @NotBlank
    String password;
    @NotBlank
    String phone;
    @NotBlank
    String email;

}
