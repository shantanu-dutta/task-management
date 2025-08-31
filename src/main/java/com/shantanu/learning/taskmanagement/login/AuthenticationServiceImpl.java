package com.shantanu.learning.taskmanagement.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Override
  public boolean authenticate(String username, String password) {
    return username.equals("admin") && password.equals("admin");
  }
}
