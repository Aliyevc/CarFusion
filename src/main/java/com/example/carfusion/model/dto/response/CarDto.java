package com.example.carfusion.model.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDto {

    String brand;
    String model;
    Integer price;
    String engineType;
    String transmission;
    String fuelType;
    Integer releaseYear;


}
