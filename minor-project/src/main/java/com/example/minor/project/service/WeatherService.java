package com.example.minor.project.service;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.dto.WeatherDataResponse;
import com.example.minor.project.mapping.RequestToWeatherData;
import com.example.minor.project.mapping.WeatherDataToWeatherDataResponse;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.repo.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepo weatherDataRepo;
    @Autowired
    private  RequestToWeatherData requestToWeatherData;
    @Autowired
    private WeatherDataToWeatherDataResponse weatherDataToWeatherDataResponse;
    public void save(RequestWeatherData requestWeatherData) {
        weatherDataRepo.save(requestToWeatherData.map(requestWeatherData));
    }
    public List<WeatherDataResponse> getWeatherByDateAndHour(LocalDate date, int hour) {
        LocalDateTime hourStart = date.atTime(hour, 0);
        LocalDateTime hourEnd = hourStart.plusHours(1); // 15:00 → 16:00
        List<WeatherDataResponse> weatherDataResponseList= new ArrayList<>();
        weatherDataRepo.findByDateAndHour(hourStart,hourEnd)
                .forEach((weatherData)->{
                    weatherDataResponseList
                            .add(weatherDataToWeatherDataResponse.map(weatherData));

                });
        return weatherDataResponseList;
    }
}
