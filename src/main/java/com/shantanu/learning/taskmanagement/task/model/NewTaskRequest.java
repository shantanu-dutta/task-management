package com.shantanu.learning.taskmanagement.task.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewTaskRequest {
  @Size(min = 3, message = "Title must be minimum 3 characters.")
  private String title;

  @Size(max = 100, message = "Description can be maximum 100 characters.")
  private String description;

  @NotBlank(message = "Target Date is required.")
  private String targetDate;

  public NewTaskRequest(String title, String description, String targetDate) {
    this.title = title;
    this.description = description;
    this.targetDate = targetDate;
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

  public String getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(String targetDate) {
    this.targetDate = targetDate;
  }

  @Override
  public String toString() {
    return "NewTaskRequest [title=" + title + ", description=" + description + ", targetDate=" + targetDate + "]";
  }
}
