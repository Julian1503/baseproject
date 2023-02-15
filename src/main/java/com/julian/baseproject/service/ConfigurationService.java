package com.julian.baseproject.service;

import com.julian.baseproject.domain.Configuration;
import com.julian.baseproject.dto.ConfigurationDto;
import com.julian.baseproject.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class ConfigurationService implements IConfigurationService {

  private final ConfigurationRepository configurationRepository;
  private final ModelMapper modelMapper;

  public ConfigurationDto createDefaultConfiguration() {
    Configuration configuration = new Configuration();
    configuration.setDateFormat(1);
    configuration.setTimeFormat(1);
    configuration.setLanguage(1);
    configurationRepository.save(configuration);
    return modelMapper.map(configuration, ConfigurationDto.class);
  }

  @Transactional
  @Modifying
  public ConfigurationDto updateConfiguration(ConfigurationDto configurationDto, Long userId) {
    return getConfigurationDto(configurationDto, userId, configurationRepository, modelMapper);
  }

  private static ConfigurationDto getConfigurationDto(ConfigurationDto configurationDto, Long userId,
      ConfigurationRepository configurationRepository, ModelMapper modelMapper) {
    Configuration configuration = configurationRepository.findByUser(userId);
    configuration.setLanguage(configurationDto.getLanguage());
    configuration.setDateFormat(configurationDto.getDateFormat());
    configuration.setTimeFormat(configurationDto.getTimeFormat());
    Configuration configurationSaved = configurationRepository.save(configuration);
    return modelMapper.map(configurationSaved, ConfigurationDto.class);
  }
}
