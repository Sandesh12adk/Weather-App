package com.example.minor.project.service;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.mapping.RequestToWeatherData;
import com.example.minor.project.repo.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepo weatherDataRepo;
    @Autowired
    private  RequestToWeatherData requestToWeatherData;
    public void save(RequestWeatherData requestWeatherData) {
        weatherDataRepo.save(requestToWeatherData.map(requestWeatherData));
    }
}
