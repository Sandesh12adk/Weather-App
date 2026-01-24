package com.example.minor.project.dto;

import lombok.Data;

@Data
public class RequestWeatherData {
    private double temp;
    private double humidity;
    private double pressure;
    private double uv;
    private boolean isRain;
}
