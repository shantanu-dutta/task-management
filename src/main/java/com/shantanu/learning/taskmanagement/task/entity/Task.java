package com.shantanu.learning.taskmanagement.task.entity;

import java.time.LocalDate;

public class Task {
  private int id;
  private String username;
  private String title;
  private String description;
  private LocalDate targetDate;
  private boolean done;

  public Task(int id, String username, String title, String description, LocalDate targetDate, boolean done) {
    this.id = id;
    this.username = username;
    this.title = title;
    this.description = description;
    this.targetDate = targetDate;
    this.done = done;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  @Override
  public String toString() {
    return "Task [id=" + id + ", username=" + username + ", title=" + title + ", description=" + description
        + ", targetDate=" + targetDate + ", done=" + done + "]";
  }
}
