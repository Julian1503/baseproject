package com.julian.baseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  private Long userId;
  private byte[] avatar;
  private String username;
  private String email;
  private String name;
  private String surname;
  private ConfigurationDto configuration;
}
