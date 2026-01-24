package com.example.minor.project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name ="weatherdata")
@EntityListeners(AuditingEntityListener.class)
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private double temp;
    @Column(nullable = false)
    private double humidity;
    @Column(nullable = false)
    private double pressure;
    @Column(nullable = false)
    private double uv;
    @Column(nullable = false)
    private boolean isRain;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dateTime;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "Location_id")
    private Location location;
}
