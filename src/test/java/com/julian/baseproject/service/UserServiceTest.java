package com.julian.baseproject.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.julian.baseproject.dto.UserDto;
import com.julian.baseproject.domain.Configuration;
import com.julian.baseproject.domain.User;
import com.julian.baseproject.repository.UserRepository;
import java.util.HexFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Mock
  private ModelMapper modelMapper;
  private User user;
  private Configuration configuration;
  private UserDto userDto;

  @BeforeEach
  void setUp() {
    user = new User();
    user.setUserId(1L);
    user.setPassword("passwordMocked");
    user.setSurname("surnameMocked");
    user.setName("nameMocked");
    user.setAvatar(HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
    user.setUsername("usernameMocked");

    userDto = new UserDto();
    userDto.setUserId(1L);
    userDto.setSurname("surnameMocked");
    userDto.setName("nameMocked");
    userDto.setAvatar(HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
    userDto.setUsername("usernameMocked");

    configuration = new Configuration();
    configuration.setConfigurationId(1L);
    configuration.setTimeFormat(1);
    configuration.setLanguage(3);
    configuration.setDateFormat(4);
  }

  @Test
  void createUserTest() {
    when(userRepository.save(any(User.class))).thenReturn(user);
    when(modelMapper.map(any(User.class),any(Class.class))).thenReturn(userDto);
    userService.createUser(userDto);
  }
}
