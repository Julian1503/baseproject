package com.julian.baseproject.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {
  @PersistenceContext
  EntityManager entityManager;

  @Bean
  public EntityManager getEntityManager() {
    entityManager.clear();
    return entityManager;
  }
}
