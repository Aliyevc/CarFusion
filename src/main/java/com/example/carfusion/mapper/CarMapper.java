package com.example.carfusion.mapper;

import com.example.carfusion.model.dto.response.CarDto;
import com.example.carfusion.model.dto.response.UserDto;
import com.example.carfusion.model.entity.Car;
import com.example.carfusion.model.entity.User;

public class CarMapper {

    public static CarDto toDto(Car car){
        if (car == null){
            return null;
        }
        CarDto carDto = new CarDto();

        carDto.setBrand(car.getBrand());
        carDto.setPrice(car.getPrice());
        carDto.setTransmission(car.getTransmission());
        carDto.setFuelType(car.getFuelType());
        carDto.setEngineType(car.getEngineType());
        carDto.setReleaseYear(carDto.getReleaseYear());

        return carDto;
    }

    public static Car toEntity(CarDto carDto){
        if (carDto == null){
            return null;
        }
        Car car = new Car();

        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setPrice(carDto.getPrice());
        car.setTransmission(carDto.getTransmission());
        car.setFuelType(carDto.getFuelType());
        car.setEngineType(carDto.getEngineType());
        car.setReleaseYear(carDto.getReleaseYear());

        return car;
    }
}

