package com.example.echart.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Week_average {
    @Id
    private Integer Id;

    private Integer day;

    private double temperature;

    public Week_average() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
