package com.example.carfusion.model.dto.request;

import lombok.Data;

@Data
public class CreateAnnouncementRequest {

     Long carId;
     String title;
     String description;
     Integer price;
     String location;
     String contactNumber;

}
