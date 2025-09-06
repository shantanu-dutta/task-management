package com.shantanu.learning.taskmanagement.task.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shantanu.learning.taskmanagement.task.entity.Task;
import com.shantanu.learning.taskmanagement.task.model.NewTaskRequest;
import com.shantanu.learning.taskmanagement.task.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
  private final TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public List<Task> findByUsername(String username) {
    return taskRepository.findByUsername(username);
  }

  @Override
  public Optional<Task> findById(int taskId) {
    return taskRepository.findById(taskId);
  }

  @Override
  public void save(String username, NewTaskRequest newTaskRequest) {
    Task newTask = new Task(
        username,
        newTaskRequest.getTitle(),
        newTaskRequest.getDescription(),
        LocalDate.parse(newTaskRequest.getTargetDate()),
        false);
    taskRepository.save(newTask);
  }

  @Override
  public void deleteById(int taskId) {
    taskRepository.deleteById(taskId);
  }

  @Override
  public Task updateById(int taskId, Task updatedTask) {
    Optional<Task> taskOptional = taskRepository.findById(taskId);

    if (!taskOptional.isPresent()) {
      // Handle case where task with given ID is not found
      throw new RuntimeException("Task not found with ID: " + taskId);
    }

    Task task = taskOptional.get();

    task.setTitle(updatedTask.getTitle());
    task.setDescription((updatedTask.getDescription()));
    task.setTargetDate(updatedTask.getTargetDate());
    task.setDone(updatedTask.isDone());

    return taskRepository.save(task);
  }
}
