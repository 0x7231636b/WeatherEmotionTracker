package com.github.x7231636b.weatheremotiontracker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherData;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherDataEntity;
import com.github.x7231636b.weatheremotiontracker.feignclient.WeatherClient;
import com.github.x7231636b.weatheremotiontracker.feignclient.response.WeatherResponse;
import com.github.x7231636b.weatheremotiontracker.mapper.WeatherDataMapper;
import com.github.x7231636b.weatheremotiontracker.repository.WeatherDataRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherDataService {
  // For later use
  private final WeatherDataRepository weatherDataRepository;

  private final WeatherClient weatherClient;

  @Value("${weather.api.key}")
  private String apiKey;

  @Value("${weather.api.units}")
  private String units;

  public WeatherData requestWeatherData(double latitude, double longitude) {
    WeatherResponse weatherResponse =
        weatherClient.getWeather(latitude, longitude, apiKey, "metric");
    WeatherData weatherData = new WeatherData();
    weatherData.setLatitude(latitude);
    weatherData.setLongitude(longitude);
    weatherData.setTemperature(weatherResponse.getMain().getTemp());
    weatherData.setHumidity(weatherResponse.getMain().getHumidity());
    weatherData.setAirPressure(weatherResponse.getMain().getPressure());
    weatherData.setVisibility(weatherResponse.getVisibility());
    weatherData.setWindSpeed(weatherResponse.getWind().getSpeed());
    weatherData.setWindGust(weatherResponse.getWind().getGust());
    weatherData.setWindDegree(weatherResponse.getWind().getDeg());
    weatherData.setWeatherCode(weatherResponse.getWeather().get(0).getId());

    return weatherData;
  }

  public WeatherDataEntity storeWeatherData(WeatherData weatherData) {
    return weatherDataRepository.save(WeatherDataMapper.instance.toEntity(weatherData));
  }
}
