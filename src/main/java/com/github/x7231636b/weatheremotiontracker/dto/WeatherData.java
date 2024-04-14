package com.github.x7231636b.weatheremotiontracker.dto;

import lombok.Data;

@Data
public class WeatherData {

  private Double latitude;
  private Double longitude;

  private Double temperature;
  private Integer humidity;
  private Integer airPressure;
  private Integer visibility;
  private Double windSpeed;
  private Double windGust;
  private Integer windDegree;

  private Integer weatherCode;

  private Long timeStamp;
}
