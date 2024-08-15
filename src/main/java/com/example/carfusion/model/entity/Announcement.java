package com.example.carfusion.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "announcements")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    Car car;
    @Column(nullable = false, length = 100)
    String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    String description;
    @Column(nullable = false)
    Integer price;
    @Column(nullable = false)
    String location;
    @Column(nullable = false)
    String contactNumber;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    Boolean isActive = true;


}

