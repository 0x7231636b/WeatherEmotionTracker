package com.github.x7231636b.weatheremotiontracker.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "user_entity")
public class UserEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(unique = true)
  private String username;
}
