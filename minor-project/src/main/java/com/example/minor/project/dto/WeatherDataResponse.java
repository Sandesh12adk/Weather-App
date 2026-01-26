package com.example.minor.project.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WeatherDataResponse {
    private double temp;
    private double humidity;
    private double pressure;
    private double uv;
    private boolean isRain;
    private LocalDateTime dateTime;
}
