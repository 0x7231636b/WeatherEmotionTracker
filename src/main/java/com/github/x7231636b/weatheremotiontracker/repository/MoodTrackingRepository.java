package com.github.x7231636b.weatheremotiontracker.repository;

import com.github.x7231636b.weatheremotiontracker.entity.Mood;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MoodTrackingRepository extends CrudRepository<Mood, String> {
  List<Mood> findByValue(byte value);

  void deleteByTimeStamp(long timeStamp);
}
