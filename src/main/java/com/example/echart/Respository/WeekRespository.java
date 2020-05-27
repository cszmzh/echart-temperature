package com.example.echart.Respository;

import com.example.echart.Entity.Week_average;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRespository extends JpaRepository<Week_average,Integer> {
    Week_average findByDay(Integer day);
}
