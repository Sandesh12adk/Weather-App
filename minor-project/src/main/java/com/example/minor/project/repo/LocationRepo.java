package com.example.minor.project.repo;

import com.example.minor.project.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long> {
    Optional<Location> findByName(String name);
}
