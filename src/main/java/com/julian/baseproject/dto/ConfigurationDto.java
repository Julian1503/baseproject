package com.julian.baseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDto {
  private Long configurationId;
  private Integer countryCode;
  private int dateFormat;
  private int timeFormat;
  private int language;
  private Long userId;
}
