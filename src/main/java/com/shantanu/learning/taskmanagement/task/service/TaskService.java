package com.shantanu.learning.taskmanagement.task.service;

import java.util.List;
import java.util.Optional;

import com.shantanu.learning.taskmanagement.task.entity.Task;
import com.shantanu.learning.taskmanagement.task.model.NewTaskRequest;

public interface TaskService {
  List<Task> findByUsername(String username);

  Optional<Task> findById(int taskId);

  void save(String username, NewTaskRequest newTask);

  void deleteById(int taskId);

  void updateById(int taskId, Task updatedTask);
}
