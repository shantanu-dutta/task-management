package com.shantanu.learning.taskmanagement.task.service;

import java.util.List;

import com.shantanu.learning.taskmanagement.task.entity.Task;
import com.shantanu.learning.taskmanagement.task.model.NewTaskRequest;

public interface TaskService {
  List<Task> findByUsername(String username);

  void save(String username, NewTaskRequest newTask);

  void deleteById(int taskId);
}
