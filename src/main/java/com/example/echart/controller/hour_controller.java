package com.example.echart.controller;


import com.example.echart.Entity.Day_average;
import com.example.echart.Entity.Hour_table720;
import com.example.echart.Entity.Week_average;
import com.example.echart.Respository.DayRespository;
import com.example.echart.Respository.HourRespository;
import com.example.echart.Respository.WeekRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Id;

@Controller
public class hour_controller {

    @Autowired
    private HourRespository hourRespository;
    @Autowired
    private DayRespository dayRespository;
    @Autowired
    private WeekRespository weekRespository;

    private Integer temp=0;
    private Integer temp1=0;
    private Integer temp2=0;
    @PostMapping(path="/save")
    @ResponseBody
    public void chucun(@RequestParam("temperature") double temperature){

        if(hourRespository.findById2(temp)==null){

            Hour_table720 hour_table720 = new Hour_table720();

            hour_table720.setId2(temp);

            hour_table720.setTemperature(temperature);

            hourRespository.save(hour_table720);

            temp=(temp+1)%720;

            if(temp==0){

                Day_average day_average = dayRespository.findByHour(temp1);

                day_average.setTemperature(hourRespository.find_average());

                dayRespository.save(day_average);

                temp1=(temp1+1);

                if(temp1==24){
                    Week_average week_average = weekRespository.findByDay(temp2);

                    week_average.setTemperature(dayRespository.find_average());

                    weekRespository.save(week_average);

                    temp2=(temp2+1)%7;
                }
                temp1=temp1%24;
            }

        }
        else {
            Hour_table720 hour_table720 = hourRespository.findById2(temp);

            hour_table720.setTemperature(temperature);

            hourRespository.save(hour_table720);

            temp=(temp+1)%720;

            if(temp==0){

                Day_average day_average = dayRespository.findByHour(temp1);

                day_average.setTemperature(hourRespository.find_average());

                dayRespository.save(day_average);

                temp1=(temp1+1);

                if(temp1==24){

                    Week_average week_average = weekRespository.findByDay(temp2);

                    week_average.setTemperature(dayRespository.find_average());

                    weekRespository.save(week_average);

                    temp2=(temp2+1)%7;
                }

                temp1=temp1%24;
            }
            System.out.println(temp);
        }
    }

    @PostMapping(path="/zhexian")
    @ResponseBody
    public double[] zhexian(){
        double[] myList = new double[6];
        for (int i=0;i<6;i++){
            myList[i]=hourRespository.findById2(i*120).getTemperature();
        }
        return myList;
    }

    @PostMapping(path = "/zhifang")
    @ResponseBody
    public double[] zhifang(){
        double[] myList = new double[7];
        for (int i=0;i<7;i++){
            myList[i]=weekRespository.findByDay(i).getTemperature();
        }
        return myList;
    }

}
