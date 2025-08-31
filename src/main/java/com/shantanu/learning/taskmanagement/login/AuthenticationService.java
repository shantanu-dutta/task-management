package com.shantanu.learning.taskmanagement.login;

public interface AuthenticationService {
  boolean authenticate(String username, String password);
}
