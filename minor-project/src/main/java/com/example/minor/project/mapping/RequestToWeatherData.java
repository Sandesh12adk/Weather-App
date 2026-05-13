package com.example.minor.project.mapping;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.model.Location;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.service.LocationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class RequestToWeatherData {
   @Value("${weather.location1.name}")
    private String location1;
   @Autowired
   private LocationService locationService;
    public WeatherData map(RequestWeatherData requestWeatherData){
        WeatherData weatherData= new WeatherData();
        weatherData.setUv(requestWeatherData.getUv());
        weatherData.setHumidity(requestWeatherData.getHumidity());
        weatherData.setRain(requestWeatherData.getIsRain());
        weatherData.setTemp(requestWeatherData.getTemp());
        weatherData.setPressure(requestWeatherData.getPressure());
        Location location= locationService.findLocationByName(location1);
        location.setName(location1);
        location.setId(location.getId());
        weatherData.setLocation(location);
        return weatherData;
    }
}
