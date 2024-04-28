package com.github.x7231636b.weatheremotiontracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherFeelingDto;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import java.util.List;

@Mapper(uses = WeatherDataMapper.class)
public interface WeatherFeelingMapper {
  WeatherFeelingMapper INSTANCE = Mappers.getMapper(WeatherFeelingMapper.class);

  @Mapping(source = "user.username", target = "username")
  @Mapping(target = "id", ignore = true)
  WeatherFeelingEntity toEntity(WeatherFeelingDto weatherFeelingDto);

  @Mapping(source = "username", target = "user.username")
  WeatherFeelingDto toDto(WeatherFeelingEntity weatherFeelingEntity);

  List<WeatherFeelingDto> toDtoList(List<WeatherFeelingEntity> entityList);
}
