package com.github.x7231636b.weatheremotiontracker.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class WeatherFeelingDto {
  private String username;

  @Min(1)
  @Max(10)
  private byte moodFeeling;

  @Min(1)
  @Max(10)
  private byte weatherFeeling;

  private BigDecimal latitude;
  private BigDecimal longitude;

  private Long timeStamp;
}
