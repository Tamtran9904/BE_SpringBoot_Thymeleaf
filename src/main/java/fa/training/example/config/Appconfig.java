package fa.training.example.config;

import fa.training.example.util.LocalDateToStringConverter;
import fa.training.example.util.StringToLocalDateConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
public class Appconfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public StringToLocalDateConverter stringToLocalDateConverter() {
    return new StringToLocalDateConverter("dd-MM-yyyy");
  }

  @Bean
  public LocalDateToStringConverter localDateToStringConverter() {
    return new LocalDateToStringConverter("dd-MM-yyyy");
  }

  @Bean
  PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityContextLogoutHandler securityContextLogoutHandler() {
    return new SecurityContextLogoutHandler();
  }
}
