package com.github.x7231636b.weatheremotiontracker.entity;

import java.math.BigDecimal;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weather_data")
public class WeatherDataEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

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
