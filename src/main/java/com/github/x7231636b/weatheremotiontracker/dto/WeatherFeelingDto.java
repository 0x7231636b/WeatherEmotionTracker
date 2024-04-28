
package com.github.x7231636b.weatheremotiontracker.dto;

import lombok.Data;

@Data
public class WeatherFeelingDto {

  private String username;
  private byte moodFeeling;
  private byte weatherFeeling;
  private WeatherData weatherData;
  private Long timeStamp;
}
