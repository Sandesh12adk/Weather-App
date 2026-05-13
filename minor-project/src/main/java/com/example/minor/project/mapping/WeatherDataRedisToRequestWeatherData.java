package com.example.minor.project.mapping;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.model.WeatherDataRedis;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataRedisToRequestWeatherData {
    public RequestWeatherData map(WeatherDataRedis weatherDataRedis){
        RequestWeatherData requestWeatherData= new  RequestWeatherData();
        requestWeatherData.setUv(weatherDataRedis.getUv());
        requestWeatherData.setTemp(weatherDataRedis.getTemp());
        requestWeatherData.setIsRain(weatherDataRedis.isRain());
        requestWeatherData.setPressure(weatherDataRedis.getPressure());
        requestWeatherData.setHumidity(weatherDataRedis.getHumidity());
        return requestWeatherData;
    }
}
