package com.example.echart.Respository;

import com.example.echart.Entity.Day_average;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DayRespository extends JpaRepository<Day_average,Integer> {
    Day_average findByHour(Integer hour);

    @Query(value = "SELECT AVG(temperature) FROM day_average",nativeQuery = true)
    double find_average();
}
