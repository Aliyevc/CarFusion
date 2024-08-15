package com.example.carfusion.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCarRequest {

    @NotBlank
    String brand;
    @NotBlank
    String model;
    @NotBlank
    Integer price;
    @NotBlank
    String engineType;
    @NotBlank
    String transmission;
    @NotBlank
    String fuelType;
    @NotBlank
    Integer releaseYear;


}
