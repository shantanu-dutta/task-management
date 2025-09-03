package com.shantanu.learning.taskmanagement.task.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shantanu.learning.taskmanagement.task.entity.Task;
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
    return "/tasks/index";
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

    return "/tasks/create";
  }

  @PostMapping()
  public String addTask(
      @Valid @ModelAttribute NewTaskRequest newTaskRequest,
      BindingResult result,
      ModelMap model) {
    if (result.hasErrors()) {
      return "redirect:/tasks/create";
    }
    String username = (String) model.get("name");
    taskService.save(username, newTaskRequest);

    return "redirect:/tasks";
  }

  @GetMapping("delete/{id}")
  public String deleteTask(@PathVariable("id") int taskId) {
    taskService.deleteById(taskId);

    return "redirect:/tasks";
  }

  @GetMapping("edit/{id}")
  public String showEditTaskPage(@PathVariable("id") int taskId, ModelMap model) {
    Optional<Task> taskOpt = taskService.findById(taskId);

    if (!taskOpt.isPresent()) {
      return "redirect:/tasks";
    }

    Task task = taskOpt.get();

    model.addAttribute("task", task);

    return "/tasks/edit";
  }

  @PostMapping("edit/{id}")
  public String updateTask(@PathVariable("id") int taskId, @Valid @ModelAttribute Task task,
      BindingResult result,
      ModelMap model) {
    if (result.hasErrors()) {
      return "redirect:/tasks/edit/" + taskId;
    }

    taskService.updateById(taskId, task);

    return "redirect:/tasks";

  }
}
