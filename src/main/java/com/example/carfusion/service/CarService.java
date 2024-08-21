package com.example.carfusion.service;

import com.example.carfusion.exception.CarNotFoundException;
import com.example.carfusion.exception.UserNotFoundException;
import com.example.carfusion.mapper.CarMapper;
import com.example.carfusion.mapper.UserMapper;
import com.example.carfusion.model.dto.request.CreateCarRequest;
import com.example.carfusion.model.dto.response.CarDto;
import com.example.carfusion.model.entity.Car;
import com.example.carfusion.repository.CarRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarService {

    CarRepository carRepository;

    public CarDto createCar(CreateCarRequest createCarRequest) {

        Car car = new Car();
        car.setBrand(createCarRequest.getBrand());
        car.setModel(createCarRequest.getModel());
        car.setPrice(createCarRequest.getPrice());
        car.setEngineType(createCarRequest.getEngineType());
        car.setFuelType(createCarRequest.getFuelType());
        car.setTransmission(createCarRequest.getTransmission());
        car.setReleaseYear(createCarRequest.getReleaseYear());
        carRepository.save(car);

        return CarMapper.toDto(car);

    }

    public String getModelById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getModel();

    }

    public String getBrandById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getBrand();

    }

    public String getTransmissionById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getTransmission();

    }

    public String getEngineTypeById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getEngineType();

    }

    public String getFuelTypeById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getFuelType();

    }

    public Integer getPriceById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getPrice();

    }

    public Integer getReleaseYearById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.toDto(car).getReleaseYear();
    }

    public void deleteCar(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException("Car Not Found"));
        car.setIsActive(false);
        carRepository.save(car);
    }

    public CarDto updateCar(Long id, CarDto carDto) {

        return carRepository.findById(id).map(existingCar -> {

                    existingCar.setFuelType(carDto.getFuelType());
                    existingCar.setModel(carDto.getModel());
                    existingCar.setEngineType(carDto.getEngineType());
                    existingCar.setBrand(carDto.getBrand());
                    existingCar.setTransmission(carDto.getTransmission());
                    existingCar.setPrice(carDto.getPrice());
                    carRepository.save(existingCar);
                    return CarMapper.toDto(existingCar);
                })
                .orElseThrow(RuntimeException::new);
    }
}
