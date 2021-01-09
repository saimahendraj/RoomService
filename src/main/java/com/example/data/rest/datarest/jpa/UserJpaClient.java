package com.example.data.rest.datarest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaClient extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String name);
}
