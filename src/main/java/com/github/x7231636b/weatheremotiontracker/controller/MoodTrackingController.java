package com.github.x7231636b.weatheremotiontracker.controller;

import com.github.x7231636b.weatheremotiontracker.entity.Mood;
import com.github.x7231636b.weatheremotiontracker.service.MoodTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mood")
public class MoodTrackingController {
  private final MoodTrackingService moodTrackingService;

  @PostMapping("/add")
  public ResponseEntity<Mood> createMood(@RequestBody Mood mood) {
    return new ResponseEntity<>(moodTrackingService.createMood(mood), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Mood>> getMood(@PathVariable String id) {
    return new ResponseEntity<>(moodTrackingService.getMood(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Mood> updateMood(@RequestBody Mood moodDetails) {
    try {
      return new ResponseEntity<>(moodTrackingService.updateMood(moodDetails), HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMood(@PathVariable String id) {
    moodTrackingService.deleteMood(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/timestamp/{timeStamp}")
  public ResponseEntity<Void> deleteMood(@PathVariable long timeStamp) {
    moodTrackingService.deleteMood(timeStamp);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
