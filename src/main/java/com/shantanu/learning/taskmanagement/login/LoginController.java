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

  @GetMapping()
  public String index() {
    return "login";
  }

  @PostMapping()
  public String login(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    return "home";
  }
}