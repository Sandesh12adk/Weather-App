package com.example.minor.project.controller;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.dto.WeatherDataResponse;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.service.WeatherRedisService;
import com.example.minor.project.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
public class WeatherController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private final WeatherRedisService weatherRedisService;
    private final WeatherService weatherService;
    public WeatherController(WeatherRedisService weatherRedisService, WeatherService weatherService){
        this.weatherRedisService= weatherRedisService;
        this.weatherService= weatherService;
    }
    @PostMapping("/weather-data")
    public ResponseEntity<?> setData(@RequestBody RequestWeatherData requestWeatherData){
      weatherRedisService.save(requestWeatherData);
        messagingTemplate.convertAndSend("/topic",requestWeatherData);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // GET /by-hour?date=2026-01-24&hour=15
    @GetMapping("/history")
    public ResponseEntity<List<WeatherDataResponse>> getWeatherByDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        return ResponseEntity.ok(weatherService.getWeatherByDate(date));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<WeatherDataResponse>> findAll(@RequestParam(required = false,defaultValue ="1") int pageNo,
                                             @RequestParam(required = false,defaultValue = "5") int pageSize){
        return ResponseEntity.ok(weatherService.findAll(pageNo,pageSize));
    }
    @GetMapping("/get-current")
    public ResponseEntity<RequestWeatherData> getCurrent(){
        return ResponseEntity.ok(weatherRedisService.getCurrentData());
    }
}