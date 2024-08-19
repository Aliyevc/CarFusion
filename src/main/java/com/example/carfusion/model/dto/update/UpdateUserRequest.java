package com.example.carfusion.model.dto.update;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserRequest {

    @NotBlank
    String email;

    @NotBlank
    String password;
}
