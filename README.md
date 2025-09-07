# Task management
This is a simple task management MVC app, built using Spring Boot 3 MVC.
The application has login functionality with hard-coded in-memory login credentials.
The application shows a simple home page to user, with links to manage their tasks.
It allows users to view tasks, create a new task with title, description, target date to finish.
Users can also edit or delte their tasks.

## Features
- Simple form-based login with username and password. The login details are currently
hard coded and use in-memory credentials.
- Simple home page with a greeting to user and link to navigate to tasks view.
- list user tasks in a card view.
- Allow user to create a new task by clicking a button in tasks view page. Create new tasks
page has following form fields:
    - __Title__ - The task title. This is a required field. This is an input field.
This must be minimum 3 characters.
    - __Decription__ - The task description. This field is optional. This is a textare field.
It can be maximum 100 characters long.
    - __Target date__ - The date to complete the task by. This field is required.
This is a date-picker field. This field value is auto set a date one week from today date.
- Allow user to edit a task. User can update following fields in the edit form.
    - __Title__ - The task title. This is a required field. This is an input field.
This must be minimum 3 characters.
    - __Decription__ - The task description. This field is optional. This is a textare field.
It can be maximum 100 characters long.
    - __Target date__ - The date to complete the task by. This field is required.
This is a date-picker field.
    - __Is completed__ - Is the task completed. This is an optional field. This is a checkbox
field with default value unchecked.
- Allow user to delete a task. In the task details list view, for each task there is a delete
button. After clicking the button a confirmation dialog box opens. If user clicks confirm button,
the task is permanently deleted.

## Technology, Frameworks and libraries
- Spring Boot Starter Web 3.5.5.
- Spring Boot Starter Data JPA 3.5.5.
- Spring Boot Starter Security 3.5.5.
- Spring Boot Starter DevTools 3.5.5.
- Bootstrap 5.3.8.
- MySQL 8.4.0.
- Spring boot DevTools 3.5.5.

## IDE
- VS Code
- Spring Tools Suite extension for VS Code.
- Java extension pack for VS Code.

## Development setup
- Start the application with `local` spring profile.
