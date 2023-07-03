package fa.training.example.config;

import fa.training.example.service.CustomUserDetailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Autowired
  private CustomUserDetailService customUserDetailService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                .requestMatchers("/styles/**").permitAll()
                .requestMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated())
        .formLogin(
            httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                .loginPage("/example/fresher/login").permitAll()
                .defaultSuccessUrl("/example/fresher/find-all", true))
        .logout((logout) -> logout
            .logoutUrl("/example/fresher/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
//            .permitAll()
        );
    return http.build();
  }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder
        .userDetailsService(customUserDetailService)
        .passwordEncoder(passwordEncoder);
  }
}
