package com.julian.baseproject.repository;

import com.julian.baseproject.domain.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
  Configuration findByUser(Long userId);
}
