package com.github.x7231636b.weatheremotiontracker.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Data
@Table(name = "mood")
public class Mood {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;


  @Min(1)
  @Max(10)
  private byte value;

  @Nullable
  private Long timeStamp;
}
