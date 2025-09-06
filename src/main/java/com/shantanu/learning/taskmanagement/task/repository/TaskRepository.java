package com.shantanu.learning.taskmanagement.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shantanu.learning.taskmanagement.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findByUsername(String username);
}
