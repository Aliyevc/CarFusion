package com.example.carfusion.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    String message;
    Integer statusCode;
    LocalDateTime timeStamp;

}