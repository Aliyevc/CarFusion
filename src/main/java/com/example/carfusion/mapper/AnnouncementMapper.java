package com.example.carfusion.mapper;

import com.example.carfusion.model.dto.response.AnnouncementDto;
import com.example.carfusion.model.entity.Announcement;
import com.example.carfusion.model.entity.Car;
import com.example.carfusion.repository.CarRepository;

public class AnnouncementMapper {

    static CarRepository carRepository;

    public static Announcement toEntity(AnnouncementDto announcementDto) {

        if (announcementDto == null ) {
            return null;
        }

        Announcement announcement = new Announcement();
        announcement.setCar(carRepository.findById(announcementDto.getCarId())
                .orElseThrow(() -> new RuntimeException("Not Found")));
        announcement.setDescription(announcementDto.getDescription());
        announcement.setPrice(announcementDto.getPrice());
        announcement.setLocation(announcementDto.getLocation());
        announcement.setTitle(announcementDto.getTitle());
        announcement.setContactNumber(announcementDto.getContactNumber());

        return announcement;
    }

    public static AnnouncementDto toDto(Announcement announcement) {

        if (announcement == null) {
            return null;
        }

        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setCarId(announcement.getCar().getId());
        announcementDto.setDescription(announcement.getDescription());
        announcementDto.setPrice(announcement.getPrice());
        announcementDto.setLocation(announcement.getLocation());
        announcement.setTitle(announcement.getTitle());
        announcement.setContactNumber(announcement.getContactNumber());

        return announcementDto;
    }

}
