package com.example.minor.project.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.List;
@Data
@RedisHash("weatherdataredis")
public class WeatherDataRedis {
    @Id
    private String id;
    private double temp;
    private double humidity;
    private double pressure;
    private double uv;
    private boolean isRain;
}

