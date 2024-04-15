package com.github.x7231636b.weatheremotiontracker.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class WeatherFeeling {
  private String username;

  @Min(1)
  @Max(10)
  private byte moodFeeling;

  @Min(1)
  @Max(10)
  private byte weatherFeeling;

  private double latitude;
  private double longitude;

  private Long timeStamp;
}
