package com.example.minor.project.service;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.dto.WeatherDataResponse;
import com.example.minor.project.mapping.RequestToWeatherData;
import com.example.minor.project.mapping.WeatherDataToWeatherDataResponse;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.repo.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<WeatherDataResponse> getWeatherByDate(LocalDate date) {

        LocalDateTime dayStart = date.atStartOfDay();      // 2026-01-26 00:00
        LocalDateTime dayEnd = dayStart.plusDays(1);       // 2026-01-27 00:00

        List<WeatherDataResponse> weatherDataResponseList = new ArrayList<>();

        weatherDataRepo.findByDateRange(dayStart, dayEnd)
                .forEach(weatherData -> {
                    weatherDataResponseList
                            .add(weatherDataToWeatherDataResponse.map(weatherData));
                });

        return weatherDataResponseList;
    }

    public List<WeatherDataResponse> findAll(int pageNo, int pageSize){
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC, "dateTime"));
        Page<WeatherData> page= weatherDataRepo.findAllByOrderByDateTimeDesc(pageable);
        List<WeatherData> weatherDataList= page.getContent();
        List<WeatherDataResponse> weatherDataResponseList= new ArrayList<>();
        weatherDataList.forEach((weatherData)->{
            weatherDataResponseList.add(weatherDataToWeatherDataResponse.map(weatherData));
        });
        return weatherDataResponseList;
    }
}
