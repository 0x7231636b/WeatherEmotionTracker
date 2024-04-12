package com.github.x7231636b.weatheremotiontracker.service;

import com.github.x7231636b.weatheremotiontracker.entity.Mood;
import com.github.x7231636b.weatheremotiontracker.repository.MoodTrackingRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoodTrackingService {

  private final MoodTrackingRepository moodTrackingRepository;

  public Mood createMoodWithValue(byte value) {
    Mood mood = new Mood();
    mood.setValue(value);
    return createMood(mood);
  }

  public Mood createMood(Mood mood) {
    if (mood.getTimeStamp() == null) {
      mood.setTimeStamp(System.currentTimeMillis());
    }
    return moodTrackingRepository.save(mood);
  }

  public Optional<Mood> getMood(String id) {
    return moodTrackingRepository.findById(id);
  }

  public Mood updateMood(Mood moodDetails) {
    Optional<Mood> optionalMood = moodTrackingRepository.findById(moodDetails.getId());

    if (!optionalMood.isPresent()) {
      throw new RuntimeException("Mood not found with id " + moodDetails.getId());
    }

    Mood mood = optionalMood.get();
    mood.setValue(moodDetails.getValue());
    mood.setTimeStamp(moodDetails.getTimeStamp());

    return moodTrackingRepository.save(mood);
  }

  public void deleteMood(String id) {
    moodTrackingRepository.deleteById(id);
  }

  public void deleteMood(long timeStamp) {
    moodTrackingRepository.deleteByTimeStamp(timeStamp);
  }

}
