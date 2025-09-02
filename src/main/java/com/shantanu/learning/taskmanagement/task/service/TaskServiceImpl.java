package com.shantanu.learning.taskmanagement.task.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shantanu.learning.taskmanagement.task.entity.Task;
import com.shantanu.learning.taskmanagement.task.model.NewTaskRequest;

@Service
public class TaskServiceImpl implements TaskService {
  private final List<Task> tasks;

  public TaskServiceImpl() {
    tasks = new ArrayList<>();
    tasks.add(
        new Task(
            1,
            "admin",
            "Learn Spring Boot 3", "Learn Spring Boot 3 related concepts, development patterns and best practices.",
            LocalDate.now().plusDays(20),
            false));
    tasks.add(
        new Task(
            2,
            "admin",
            "Learn Docker", "Learn docker related concepts and commands.",
            LocalDate.now().plusMonths(1),
            false));
    tasks.add(
        new Task(
            3,
            "admin",
            "Learn Kubernetes",
            "Learn kubernetes related concepts and commands.",
            LocalDate.now().plusMonths(2),
            false));
  }

  @Override
  public List<Task> findByUsername(String username) {
    return tasks.stream()
        .filter(task -> task.getUsername().equals(username))
        .collect(Collectors.toList());
  }

  @Override
  public void save(String username, NewTaskRequest newTaskRequest) {
    int newTaskId = tasks.size() + 1;
    Task newTask = new Task(
        newTaskId,
        username,
        newTaskRequest.getTitle(),
        newTaskRequest.getDescription(),
        LocalDate.parse(newTaskRequest.getTargetDate()),
        false);
    tasks.add(newTask);
  }

  @Override
  public void deleteById(int taskId) {
    tasks.removeIf(task -> task.getId() == taskId);
  }
}
