package com.github.x7231636b.weatheremotiontracker.repository;

import org.springframework.data.repository.CrudRepository;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherDataEntity;

public interface WeatherDataRepository extends CrudRepository<WeatherDataEntity, String> {
  // todo: Maybe it is a good idea to have a script that creates an entity, the Repository, service
  // and controller all at once. Python could be a quick way to do this.
}
