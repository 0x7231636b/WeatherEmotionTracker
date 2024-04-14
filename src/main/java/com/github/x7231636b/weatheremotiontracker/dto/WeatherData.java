package com.github.x7231636b.weatheremotiontracker.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class WeatherData {

  private BigDecimal latitude;
  private BigDecimal longitude;

  private Float temperature;
  private Float humidity;
  private Float airPressure;
  private Integer visibility;
  private Double windSpeed;
  private Double windGust;
  private Integer windDegree;

  private Long timeStamp;
}
