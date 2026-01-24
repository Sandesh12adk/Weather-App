package com.example.minor.project.service;

import com.example.minor.project.exception.ResourceNotFoundExceptoin;
import com.example.minor.project.model.Location;
import com.example.minor.project.repo.LocationRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.DocumentationTool;

@Service
public class LocationService {
    @Autowired
    private LocationRepo locationRepo;
    public Location findLocationByName(String name){
        return locationRepo.findByName(name)
                .orElseThrow(
                        ()-> new ResourceNotFoundExceptoin("Cannot Find the location "+ name));
    }
}
