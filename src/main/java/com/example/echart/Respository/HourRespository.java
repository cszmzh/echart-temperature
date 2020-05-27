package com.example.echart.Respository;

import com.example.echart.Entity.Hour_table720;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HourRespository extends JpaRepository<Hour_table720,Integer>{
    Hour_table720 findById2(Integer id2);

    @Query("SELECT AVG(temperature) FROM Hour_table720")
    double find_average();
}
