package com.shantanu.learning.taskmanagement.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {

  private final AuthenticationService authService;

  public LoginController(AuthenticationService authService) {
    this.authService = authService;
  }

  @GetMapping()
  public String index() {
    return "login";
  }

  @PostMapping()
  public String login(@RequestParam String name, @RequestParam String password, ModelMap model) {
    // authentication
    if(!authService.authenticate(name, password)) {
      model.put("errorMessage", "Invalid username or password");
      return "login";
    }

    model.put("name", name);
    return "home";
  }
}