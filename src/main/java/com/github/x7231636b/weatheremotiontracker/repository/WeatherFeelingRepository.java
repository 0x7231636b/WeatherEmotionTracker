package com.github.x7231636b.weatheremotiontracker.repository;

import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WeatherFeelingRepository extends CrudRepository<WeatherFeelingEntity, String> {
  List<WeatherFeelingEntity> findByValue(byte value);

  void deleteByTimeStamp(long timeStamp);
}
