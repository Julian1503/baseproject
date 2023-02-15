package com.julian.baseproject.service;

import com.julian.baseproject.dto.ConfigurationDto;

public interface IConfigurationService {
  ConfigurationDto updateConfiguration(ConfigurationDto configurationDto, Long userId);
  ConfigurationDto createDefaultConfiguration();
}
