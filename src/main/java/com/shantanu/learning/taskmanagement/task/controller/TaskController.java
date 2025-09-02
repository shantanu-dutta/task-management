package com.shantanu.learning.taskmanagement.task.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shantanu.learning.taskmanagement.task.model.NewTaskRequest;
import com.shantanu.learning.taskmanagement.task.service.TaskService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")
@SessionAttributes("name")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping()
  public String index(ModelMap model) {
    String username = (String) model.get("name");
    ;
    model.put("tasks", taskService.findByUsername(username));
    return "tasks/index";
  }

  @GetMapping("create")
  public String showNewTaskPage(ModelMap model) {
    NewTaskRequest newTaskRequest = new NewTaskRequest(
        "",
        "",
        LocalDate.now().plusWeeks(1).toString());

    if (!model.containsAttribute("newTaskRequest")) {
      model.addAttribute("newTaskRequest", newTaskRequest);
    }

    return "tasks/create";
  }

  @PostMapping()
  public String addTask(
      @Valid @ModelAttribute NewTaskRequest newTaskRequest,
      BindingResult result,
      RedirectAttributes redirectAttributes,
      ModelMap model) {
    if (result.hasErrors()) {
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newTaskRequest", result);
      redirectAttributes.addFlashAttribute("newTaskRequest", newTaskRequest);
      redirectAttributes.addFlashAttribute("hasError", true);
      return "redirect:/tasks/create";
    }
    String username = (String) model.get("name");
    taskService.save(username, newTaskRequest);

    return "redirect:/tasks";
  }

}
