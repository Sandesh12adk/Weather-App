package com.example.minor.project.mapping;

import com.example.minor.project.dto.WeatherDataResponse;
import com.example.minor.project.model.WeatherData;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataToWeatherDataResponse {
    public WeatherDataResponse map(WeatherData weatherData) {
        WeatherDataResponse weatherDataResponse = new WeatherDataResponse();
        weatherDataResponse.setUv(weatherData.getUv());
        weatherDataResponse.setTemp(weatherData.getTemp());
        weatherDataResponse.setRain(weatherData.isRain());
        weatherDataResponse.setPressure(weatherData.getPressure());
        weatherDataResponse.setHumidity(weatherData.getHumidity());
        weatherDataResponse.setDateTime(weatherData.getDateTime());
        return weatherDataResponse;
    }
}
