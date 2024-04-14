package com.github.x7231636b.weatheremotiontracker.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.x7231636b.weatheremotiontracker.feignclient.response.WeatherResponse;

@FeignClient(name = "weatherClient", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherClient {

  @GetMapping("/weather")
  WeatherResponse getWeather(@RequestParam("lat") double latitude,
      @RequestParam("lon") double longitude, @RequestParam("appid") String appId,
      @RequestParam("units") String units);
}
