package com.example.carfusion.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String brand;
    @Column(nullable = false)
    String model;
    Integer price;
    @Column(nullable = false)
    String engineType;
    @Column(nullable = false)
    String transmission;
    @Column(nullable = false)
    String fuelType;
    @Column(nullable = false)
    Integer releaseYear;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    Boolean isActive = true;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    List<Announcement> announcementList;
}
