package com.example.minor.project.mapping;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.model.WeatherDataRedis;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Data
@Component
public class RequestToWeatherDataRedis {
    public WeatherDataRedis map(RequestWeatherData requestWeatherData) {
        WeatherDataRedis weatherDataRedis = new WeatherDataRedis();
        weatherDataRedis.setId(LocalTime.now().toString());
        weatherDataRedis.setUv(requestWeatherData.getUv());
        weatherDataRedis.setRain(requestWeatherData.isRain());
        weatherDataRedis.setHumidity(requestWeatherData.getHumidity());
        weatherDataRedis.setTemp(requestWeatherData.getTemp());
        weatherDataRedis.setPressure(requestWeatherData.getPressure());
        return weatherDataRedis;
    }
}
