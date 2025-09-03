<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit task ${task.title} - Task Management</title>
    <link
      rel="stylesheet"
      href="/webjars/bootstrap/5.3.8/css/bootstrap.min.css"
    />
  </head>
  <body>
    <main class="container mt-4">
      <h1>Edit task <em>${task.title}</em></h1>
      <p>
        Please update the task values in the following form and submit to update
        the task
        <em>${task.title}</em>.
      </p>
      <form:form
        action="/tasks/edit/${task.id}"
        method="post"
        modelAttribute="task"
        novalidate="true"
      >
        <div class="mb-3">
          <label for="task-title" class="form-label">Title</label>
          <form:input
            type="text"
            id="task-title"
            path="title"
            cssClass="form-control"
          />
          <form:errors path="title" cssClass="text-danger" />
        </div>
        <div class="mb-3">
          <label for="task-description" class="form-label">Description</label>
          <form:textarea
            rows="3"
            id="task-description"
            path="description"
            class="form-control ${status.error ? 'is-invalid' : ''}"
          ></form:textarea>
          <form:errors path="description" cssClass="text-danger" />
        </div>
        <div class="mb-3">
          <label for="task-target-date" class="form-label">Complete by</label>
          <form:input
            type="date"
            class="form-control"
            id="task-target-date"
            path="targetDate"
          />
          <form:errors path="targetDate" cssClass="text-danger" />
        </div>
        <div class="mb-3 form-check">
          <form:checkbox
            class="form-check-input"
            id="task-completed"
            path="done"
          />
          <label for="task-completed" class="form-check-label">Task completed</label>
          <form:errors path="done" cssClass="text-danger" />
        </div>
        <div>
          <button type="submit" class="btn btn-success mr-2">Update</button>
          <a href="/tasks" class="btn">Cancel</a>
        </div>
      </form:form>
    </main>
  </body>
</html>
