package com.github.x7231636b.weatheremotiontracker.repository;

import com.github.x7231636b.weatheremotiontracker.entity.UserEntity;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface WeatherFeelingRepository extends CrudRepository<WeatherFeelingEntity, String> {

  void deleteByTimeStamp(long timeStamp);

  List<WeatherFeelingEntity> findAllByUser(UserEntity user);
}
