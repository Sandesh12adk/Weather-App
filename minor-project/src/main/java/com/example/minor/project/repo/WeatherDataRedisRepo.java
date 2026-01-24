package com.example.minor.project.repo;

import com.example.minor.project.model.WeatherDataRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRedisRepo extends CrudRepository<WeatherDataRedis,String> {
}
