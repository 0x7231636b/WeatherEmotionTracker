package com.github.x7231636b.weatheremotiontracker.service;

import com.github.x7231636b.weatheremotiontracker.entity.Mood;
import com.github.x7231636b.weatheremotiontracker.entity.User;
import com.github.x7231636b.weatheremotiontracker.repository.MoodTrackingRepository;
import com.github.x7231636b.weatheremotiontracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoodTrackingService {

  private final MoodTrackingRepository moodTrackingRepository;
  private final UserRepository userRepository;

  public Mood createMood(Mood mood) {
    if (mood.getTimeStamp() == null) {
      mood.setTimeStamp(System.currentTimeMillis());
    }

    User user = createUserIfNonexistent(mood.getUser().getUsername());
    mood.setUser(user);

    return moodTrackingRepository.save(mood);
  }

  private User createUserIfNonexistent(String username) {
    User user = userRepository.findByUsername(username).orElseGet(() -> {
      User newUser = new User();
      newUser.setUsername(username);
      return userRepository.save(newUser);
    });
    return user;
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
