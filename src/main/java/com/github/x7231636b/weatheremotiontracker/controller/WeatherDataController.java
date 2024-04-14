package com.github.x7231636b.weatheremotiontracker.controller;

import org.springframework.web.bind.annotation.RestController;
import com.github.x7231636b.weatheremotiontracker.service.WeatherDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/weather")
public class WeatherDataController {

  WeatherDataService weatherDataService;

  @PostMapping("/between")
  public ResponseEntity<Void> pollDataBetween(BigDecimal start, BigDecimal end) {
    // TODO: Use feign client to poll data from weather service that stores data from the past
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
