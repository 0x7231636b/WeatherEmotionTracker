package com.github.x7231636b.weatheremotiontracker.feignclient.response;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {
  @Data
  public static class Coord {
    private double lon;
    private double lat;
  }

  @Data
  public static class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
  }

  @Data
  public static class Main {
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
  }

  @Data
  public static class Wind {
    private double speed;
    private int deg;
    private double gust;
  }

  @Data
  public static class Clouds {
    private int all;
  }

  @Data
  public static class Sys {
    private int type;
    private long id;
    private String country;
    private long sunrise;
    private long sunset;
  }

  private Coord coord;
  private List<Weather> weather;
  private String base;
  private Main main;
  private int visibility;
  private Wind wind;
  private Clouds clouds;
  private long dt;
  private Sys sys;
  private int timezone;
  private long id;
  private String name;
  private int cod;
}
