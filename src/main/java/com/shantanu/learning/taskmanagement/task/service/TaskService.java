package com.shantanu.learning.taskmanagement.task.service;

import java.util.List;

import com.shantanu.learning.taskmanagement.task.entity.Task;
import com.shantanu.learning.taskmanagement.task.model.NewTaskRequest;

public interface TaskService {
  public List<Task> findByUsername(String username);

  public void save(String username, NewTaskRequest newTask);
}
