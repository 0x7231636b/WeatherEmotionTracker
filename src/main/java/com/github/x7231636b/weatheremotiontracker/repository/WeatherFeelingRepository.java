package com.github.x7231636b.weatheremotiontracker.repository;

import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import org.springframework.data.repository.CrudRepository;

public interface WeatherFeelingRepository extends CrudRepository<WeatherFeelingEntity, String> {

  void deleteByTimeStamp(long timeStamp);
}
