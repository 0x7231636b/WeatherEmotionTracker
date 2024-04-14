package com.github.x7231636b.weatheremotiontracker.service;

import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import com.github.x7231636b.weatheremotiontracker.mapper.WeatherDataMapper;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherData;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherFeelingDto;
import com.github.x7231636b.weatheremotiontracker.entity.UserEntity;
import com.github.x7231636b.weatheremotiontracker.repository.WeatherFeelingRepository;
import com.github.x7231636b.weatheremotiontracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherFeelingService {

  private final WeatherFeelingRepository weatherDataRepository;
  private final UserRepository userRepository;

  private final WeatherDataService weatherDataService;

  public void createWeatherFeeling(WeatherFeelingDto weatherFeeling) {
    if (weatherFeeling.getTimeStamp() == null) {
      weatherFeeling.setTimeStamp(System.currentTimeMillis());
    }

    UserEntity user = createUserIfNonexistent(weatherFeeling.getUsername());

    WeatherFeelingEntity weatherFeelingEntity = new WeatherFeelingEntity();
    weatherFeelingEntity.setUser(user);

    WeatherData weatherData = weatherDataService.requestWeatherData(weatherFeeling.getLatitude(),
        weatherFeeling.getLongitude());

    weatherFeelingEntity.setWeatherData(WeatherDataMapper.instance.toEntity(weatherData));

    weatherDataRepository.save(weatherFeelingEntity);
  }

  private UserEntity createUserIfNonexistent(String username) {
    UserEntity user = userRepository.findByUsername(username).orElseGet(() -> {
      UserEntity newUser = new UserEntity();
      newUser.setUsername(username);
      return userRepository.save(newUser);
    });
    return user;
  }

  public Optional<WeatherFeelingDto> getWeatherFeeling(String id) {

    Optional<WeatherFeelingEntity> weatherFeelingOptional = weatherDataRepository.findById(id);

    if (!weatherFeelingOptional.isPresent()) {
      return Optional.empty();
    }

    WeatherFeelingEntity weatherFeeling = weatherFeelingOptional.get();
    WeatherFeelingDto weatherFeelingRequest = new WeatherFeelingDto();
    weatherFeelingRequest.setMoodFeeling(weatherFeeling.getMoodFeeling());
    weatherFeelingRequest.setWeatherFeeling(weatherFeeling.getWeatherFeeling());

    return Optional.of(weatherFeelingRequest);
  }

  public void updateWeatherFeeling(WeatherFeelingDto weatherFeelingRequest, String id) {
    Optional<WeatherFeelingEntity> weatherFeelingOptional = weatherDataRepository.findById(id);

    if (!weatherFeelingOptional.isPresent()) {
      throw new RuntimeException("Mood not found with id " + id);
    }

    WeatherFeelingEntity weatherFeeling = weatherFeelingOptional.get();

    weatherFeeling.setMoodFeeling(weatherFeelingRequest.getMoodFeeling());
    weatherFeeling.setWeatherFeeling(weatherFeelingRequest.getWeatherFeeling());

    weatherDataRepository.save(weatherFeeling);
  }

  public void deleteWeatherFeeling(String id) {
    weatherDataRepository.deleteById(id);
  }

  public void deleteWeatherFeeling(long timeStamp) {
    weatherDataRepository.deleteByTimeStamp(timeStamp);
  }

}
