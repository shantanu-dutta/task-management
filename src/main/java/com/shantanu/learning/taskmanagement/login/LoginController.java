package com.shantanu.learning.taskmanagement.login;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

  @GetMapping()
  public String index(@RequestParam("name") Optional<String> nameOpt, ModelMap model) {
    String name = nameOpt.orElse("Guest");
    model.put("name", name);

    return "login";
  }
}
