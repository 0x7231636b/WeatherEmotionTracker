package com.github.x7231636b.weatheremotiontracker.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.github.x7231636b.weatheremotiontracker.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

  Optional<UserEntity> findByUsername(String username);

}
