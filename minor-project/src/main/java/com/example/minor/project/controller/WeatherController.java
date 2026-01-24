package com.example.minor.project.controller;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.service.WeatherRedisService;
import com.example.minor.project.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherRedisService weatherRedisService;
    public WeatherController(WeatherRedisService weatherRedisService){
        this.weatherRedisService= weatherRedisService;
    }
    @PostMapping("/weather-data")
    public ResponseEntity<?> setData(@RequestBody RequestWeatherData requestWeatherData){
      weatherRedisService.save(requestWeatherData);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
