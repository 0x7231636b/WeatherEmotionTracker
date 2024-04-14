package com.github.x7231636b.weatheremotiontracker.entity;

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

  private double latitude;
  private double longitude;

  private Double temperature;
  private Double humidity;
  private Double airPressure;
  private Integer visibility;
  private Double windSpeed;
  private Double windGust;
  private Integer windDegree;

  private Long timeStamp;
}
