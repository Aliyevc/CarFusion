package com.example.carfusion.model.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnouncementDto {

     Long carId;
     String title;
     String description;
     Integer price;
     String location;
     String contactNumber;
     Boolean isActive;

}
