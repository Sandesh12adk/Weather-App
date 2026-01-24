package com.example.minor.project.service;

import com.example.minor.project.dto.RequestWeatherData;
import com.example.minor.project.mapping.RequestToWeatherDataRedis;
import com.example.minor.project.mapping.WeatherDataRedisToRequestWeatherData;
import com.example.minor.project.model.WeatherData;
import com.example.minor.project.model.WeatherDataRedis;
import com.example.minor.project.repo.WeatherDataRedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherRedisService {


    @Autowired
    private WeatherDataRedisRepo weatherDataRedisRepo;
    @Autowired
    private RequestToWeatherDataRedis requestToWeatherDataRedis;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherDataRedisToRequestWeatherData weatherDataRedisToRequestWeatherData;
    public void save(RequestWeatherData requestWeatherData){
    weatherDataRedisRepo.save(requestToWeatherDataRedis.map(requestWeatherData));
    }
    @Scheduled(cron = "0 0 * * * *")
    public void saveToDataBaseFromRedis(){
        List<WeatherDataRedis> list= new ArrayList<>();
        weatherDataRedisRepo.findAll().forEach(list::add);
        int size= list.size();
        if(size==0){return; }
        double totalTemp=0;
        double totalHumidity=0;
        double totalPressure=0;
        double totalUv=0;
        int rainCount=0;
        for(WeatherDataRedis weatherDataRedis: list){
            totalTemp+=weatherDataRedis.getTemp();
            totalHumidity+= weatherDataRedis.getHumidity();
            totalPressure+= weatherDataRedis.getPressure();
            totalUv+= weatherDataRedis.getUv();
            if(weatherDataRedis.isRain()==true){rainCount++;}
               }

        WeatherDataRedis weatherDataRedis1= new WeatherDataRedis();
        weatherDataRedis1.setPressure(totalPressure/size);
        weatherDataRedis1.setUv(totalUv/size);
        weatherDataRedis1.setHumidity(totalHumidity/size);
        weatherDataRedis1.setTemp(totalTemp/size);
        weatherDataRedis1.setRain(rainCount>size/4);
        weatherService.save(weatherDataRedisToRequestWeatherData.map(weatherDataRedis1));
        weatherDataRedisRepo.deleteAll();
    }
}
