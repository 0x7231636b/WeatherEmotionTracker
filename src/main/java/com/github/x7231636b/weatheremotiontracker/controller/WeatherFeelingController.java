package com.github.x7231636b.weatheremotiontracker.controller;

import com.github.x7231636b.weatheremotiontracker.dto.WeatherFeelingDto;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import com.github.x7231636b.weatheremotiontracker.service.WeatherFeelingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weather-feeling")
public class WeatherFeelingController {
  private final WeatherFeelingService weatherFeelingService;

  @PostMapping("/add")
  public ResponseEntity<Void> createWeatherFeeling(@RequestBody WeatherFeelingDto weatherFeeling) {
    weatherFeelingService.createWeatherFeeling(weatherFeeling);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<WeatherFeelingDto>> getWeatherFeeling(@PathVariable String id) {
    return new ResponseEntity<>(weatherFeelingService.getWeatherFeeling(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateWeatherFeeling(@RequestBody WeatherFeelingDto weatherFeelingDto,
      @PathVariable String id) {
    try {
      weatherFeelingService.updateWeatherFeeling(weatherFeelingDto, id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteWeatherFeeling(@PathVariable String id) {
    weatherFeelingService.deleteWeatherFeeling(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/timestamp/{timeStamp}")
  public ResponseEntity<Void> deleteWeatherFeeling(@PathVariable long timeStamp) {
    weatherFeelingService.deleteWeatherFeeling(timeStamp);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
