package com.shantanu.learning.taskmanagement.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("name")
public class HomeController {

  @GetMapping()
  public String goToHomePage(ModelMap model) {
    model.put("name", "admin");
    return "index";
  }
}