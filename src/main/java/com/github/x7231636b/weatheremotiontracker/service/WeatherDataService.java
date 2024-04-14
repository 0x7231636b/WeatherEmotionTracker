package com.github.x7231636b.weatheremotiontracker.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherData;
import com.github.x7231636b.weatheremotiontracker.repository.WeatherDataRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherDataService {
  final WeatherDataRepository weatherDataRepository;

  public WeatherData requestWeatherData(BigDecimal latitude, BigDecimal longitude) {
    return null;
  }
}
