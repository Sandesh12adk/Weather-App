package com.example.minor.project.repo;

import com.example.minor.project.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepo extends JpaRepository<WeatherData, Long> {
}
