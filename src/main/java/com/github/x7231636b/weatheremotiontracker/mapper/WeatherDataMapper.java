package com.github.x7231636b.weatheremotiontracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherData;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherDataEntity;

@Mapper
public interface WeatherDataMapper {
  WeatherDataMapper instance = Mappers.getMapper(WeatherDataMapper.class);

  @Mapping(target = "id", ignore = true)
  WeatherDataEntity toEntity(WeatherData weatherData);

  WeatherData toDto(WeatherDataEntity weatherDataEntity);
}
