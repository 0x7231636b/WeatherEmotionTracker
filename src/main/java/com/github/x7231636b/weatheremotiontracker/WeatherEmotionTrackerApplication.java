package com.github.x7231636b.weatheremotiontracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherEmotionTrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherEmotionTrackerApplication.class, args);
  }

}
