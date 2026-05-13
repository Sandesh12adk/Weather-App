package com.example.minor.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestWeatherData {

    @NotNull(message = "Temperature is required")
    private Double temp;

    @NotNull(message = "Humidity is required")
    private Double humidity;

    @NotNull(message = "Pressure is required")
    private Double pressure;

    @NotNull(message = "UV value is required")
    private Double uv;

    @NotNull(message = "Rain status is required")
    private Boolean isRain;
}