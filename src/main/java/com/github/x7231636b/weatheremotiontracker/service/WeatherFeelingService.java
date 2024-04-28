package com.github.x7231636b.weatheremotiontracker.service;

import com.github.x7231636b.weatheremotiontracker.entity.WeatherFeelingEntity;
import com.github.x7231636b.weatheremotiontracker.mapper.WeatherFeelingMapper;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherData;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherFeeling;
import com.github.x7231636b.weatheremotiontracker.dto.WeatherFeelingDto;
import com.github.x7231636b.weatheremotiontracker.entity.UserEntity;
import com.github.x7231636b.weatheremotiontracker.entity.WeatherDataEntity;
import com.github.x7231636b.weatheremotiontracker.repository.WeatherFeelingRepository;
import com.github.x7231636b.weatheremotiontracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherFeelingService {

  private final WeatherFeelingRepository weatherFeelingRepository;
  private final UserRepository userRepository;

  private final WeatherDataService weatherDataService;

  public void createWeatherFeeling(WeatherFeeling weatherFeeling) {
    if (weatherFeeling.getTimeStamp() == null) {
      weatherFeeling.setTimeStamp(System.currentTimeMillis());
    }

    UserEntity user = createUserIfNonexistent(weatherFeeling.getUsername());

    WeatherFeelingEntity weatherFeelingEntity = new WeatherFeelingEntity();
    weatherFeelingEntity.setUser(user);

    WeatherData weatherData = weatherDataService.requestWeatherData(weatherFeeling.getLatitude(),
        weatherFeeling.getLongitude());
    weatherData.setTimeStamp(weatherFeeling.getTimeStamp());

    WeatherDataEntity weatherDataEntity = weatherDataService.storeWeatherData(weatherData);

    weatherFeelingEntity.setWeatherData(weatherDataEntity);

    weatherFeelingEntity.setMoodFeeling(weatherFeeling.getMoodFeeling());
    weatherFeelingEntity.setWeatherFeeling(weatherFeeling.getWeatherFeeling());
    weatherFeelingEntity.setTimeStamp(weatherFeeling.getTimeStamp());

    System.out.println("About to store weather feeling:" + weatherFeelingEntity);

    weatherFeelingRepository.save(weatherFeelingEntity);
  }

  private UserEntity createUserIfNonexistent(String username) {
    UserEntity user = userRepository.findByUsername(username).orElseGet(() -> {
      UserEntity newUser = new UserEntity();
      newUser.setUsername(username);
      return userRepository.save(newUser);
    });
    return user;
  }

  public Optional<WeatherFeeling> getWeatherFeeling(String id) {

    Optional<WeatherFeelingEntity> weatherFeelingOptional = weatherFeelingRepository.findById(id);

    if (!weatherFeelingOptional.isPresent()) {
      return Optional.empty();
    }

    WeatherFeelingEntity weatherFeeling = weatherFeelingOptional.get();
    WeatherFeeling weatherFeelingRequest = new WeatherFeeling();
    weatherFeelingRequest.setMoodFeeling(weatherFeeling.getMoodFeeling());
    weatherFeelingRequest.setWeatherFeeling(weatherFeeling.getWeatherFeeling());

    return Optional.of(weatherFeelingRequest);
  }

  public void updateWeatherFeeling(WeatherFeeling weatherFeelingRequest, String id) {
    Optional<WeatherFeelingEntity> weatherFeelingOptional = weatherFeelingRepository.findById(id);

    if (!weatherFeelingOptional.isPresent()) {
      throw new RuntimeException("Entry not found with id " + id);
    }

    WeatherFeelingEntity weatherFeeling = weatherFeelingOptional.get();

    weatherFeeling.setMoodFeeling(weatherFeelingRequest.getMoodFeeling());
    weatherFeeling.setWeatherFeeling(weatherFeelingRequest.getWeatherFeeling());

    weatherFeelingRepository.save(weatherFeeling);
  }

  public void deleteWeatherFeeling(String id) {
    weatherFeelingRepository.deleteById(id);
  }

  public void deleteWeatherFeeling(long timeStamp) {
    weatherFeelingRepository.deleteByTimeStamp(timeStamp);
  }

  public List<WeatherFeelingDto> getAllWeatherFeelings(String username) {
    UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();

    List<WeatherFeelingEntity> weatherFeelingEntity =
        weatherFeelingRepository.findAllByUser(userEntity);
    return WeatherFeelingMapper.INSTANCE.toDtoList(weatherFeelingEntity);
  }

}
