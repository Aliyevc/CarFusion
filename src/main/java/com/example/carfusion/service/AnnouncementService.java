package com.example.carfusion.service;

import com.example.carfusion.exception.AnnouncementNotFoundException;
import com.example.carfusion.mapper.AnnouncementMapper;
import com.example.carfusion.mapper.CarMapper;
import com.example.carfusion.model.dto.request.CreateAnnouncementRequest;
import com.example.carfusion.model.dto.request.CreateCarRequest;
import com.example.carfusion.model.dto.response.AnnouncementDto;
import com.example.carfusion.model.dto.response.CarDto;
import com.example.carfusion.model.entity.Announcement;
import com.example.carfusion.model.entity.Car;
import com.example.carfusion.repository.AnnouncementRepository;
import com.example.carfusion.repository.CarRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnnouncementService {

    AnnouncementRepository announcementRepository;
    CarRepository carRepository;


    public AnnouncementDto createAnnouncement(CreateAnnouncementRequest createAnnouncementRequest) {

        Announcement announcement = new Announcement();
        announcement.setContactNumber(createAnnouncementRequest.getContactNumber());
        announcement.setLocation(createAnnouncementRequest.getLocation());
        announcement.setPrice(createAnnouncementRequest.getPrice());
        announcement.setTitle(createAnnouncementRequest.getTitle());
        announcement.setDescription(createAnnouncementRequest.getDescription());
        announcement.setCar(carRepository.findById(createAnnouncementRequest.getCarId())
                .orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found")));
        announcementRepository.save(announcement);

        return AnnouncementMapper.toDto(announcement);

    }

    public String getContactNumberById(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found")));

        return AnnouncementMapper.toDto(announcement).getContactNumber();

    }

    public String getLocationById(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found")));

        return AnnouncementMapper.toDto(announcement).getLocation();

    }

    public String getTitleById(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));

        return AnnouncementMapper.toDto(announcement).getTitle();

    }

    public String getDescription(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));

        return AnnouncementMapper.toDto(announcement).getDescription();

    }

    public String getFuelTypeById(Long id) {

        Car car = carRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));

        return CarMapper.toDto(car).getFuelType();

    }

    public Integer getPriceById(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));

        return AnnouncementMapper.toDto(announcement).getPrice();

    }

    public CarDto getCarById(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));

        CarDto car = CarMapper.toDto(announcement.getCar());

        return car;
    }

    public void deleteAnnouncement(Long id) {

        Announcement announcement = announcementRepository.findById(id).
                orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));
        announcement.setIsActive(false);
        announcementRepository.save(announcement);
    }

    public AnnouncementDto updateAnnouncement(Long id, AnnouncementDto announcementDto) {

        return announcementRepository.findById(id).map(existingAnnouncement -> {

                    existingAnnouncement.setDescription(announcementDto.getDescription());
                    existingAnnouncement.setContactNumber(announcementDto.getContactNumber());
                    existingAnnouncement.setLocation(announcementDto.getLocation());
                    existingAnnouncement.setTitle(announcementDto.getTitle());
                    existingAnnouncement.setCar(carRepository.findById(announcementDto.getCarId())
                            .orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found")));
                    existingAnnouncement.setPrice(announcementDto.getPrice());
                    announcementRepository.save(existingAnnouncement);
                    return AnnouncementMapper.toDto(existingAnnouncement);
                })
                .orElseThrow(() -> new AnnouncementNotFoundException("Announcement Not Found"));
    }
}
