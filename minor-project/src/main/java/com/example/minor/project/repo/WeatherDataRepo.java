package com.example.minor.project.repo;

import com.example.minor.project.model.WeatherData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WeatherDataRepo extends JpaRepository<WeatherData, Long> {

        @Query("""
        SELECT w FROM WeatherData w
        WHERE w.dateTime >= :hourStart AND w.dateTime < :hourEnd
    """)
        // SELECT *
            //FROM weatherdata
            //WHERE date_time >= '2026-01-26 14:00:00'
            //  AND date_time <  '2026-01-26 15:00:00';
        List<WeatherData> findByDateAndHour(
                @Param("hourStart") LocalDateTime hourStart,
                @Param("hourEnd") LocalDateTime hourEnd
        );
        Page<WeatherData> findAllByOrderByDateTimeDesc(Pageable pageable);
        @Query("""
    SELECT w FROM WeatherData w
    WHERE w.dateTime >= :start
      AND w.dateTime < :end
    ORDER BY w.dateTime ASC
""")
        List<WeatherData> findByDateRange(
                @Param("start") LocalDateTime start,
                @Param("end") LocalDateTime end
        );


}

