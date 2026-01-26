package com.example.minor.project.controller;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.dto.WeatherDataResponse;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.service.WeatherRedisService;
import com.example.minor.project.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WeatherController {
    private final WeatherRedisService weatherRedisService;
    private final WeatherService weatherService;
    public WeatherController(WeatherRedisService weatherRedisService, WeatherService weatherService){
        this.weatherRedisService= weatherRedisService;
        this.weatherService= weatherService;
    }
    @PostMapping("/weather-data")
    public ResponseEntity<?> setData(@RequestBody RequestWeatherData requestWeatherData){
      weatherRedisService.save(requestWeatherData);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // GET /by-hour?date=2026-01-24&hour=15
    @GetMapping("/by-hour")
    public List<WeatherDataResponse> getWeatherByHour(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam int hour
    ) {
        return weatherService.getWeatherByDateAndHour(date, hour);
    }
}
