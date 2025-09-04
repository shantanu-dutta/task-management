package com.shantanu.learning.taskmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {

  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    UserDetails userDetails1 = createNewUser("admin", "admin");
    UserDetails userDetails2 = createNewUser("john", "dummy");

    return new InMemoryUserDetailsManager(userDetails1, userDetails2);
  }

  private UserDetails createNewUser(String username, String password) {
    UserDetails userDetails = User.builder()
        .passwordEncoder(plainTextPwd -> passwordEncoder().encode(plainTextPwd))
        .username(username)
        .password(password)
        .roles("USER", "admin")
        .build();
    return userDetails;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
