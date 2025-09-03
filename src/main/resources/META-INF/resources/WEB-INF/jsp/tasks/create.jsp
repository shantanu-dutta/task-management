<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create New Task - Task Management</title>
    <link
      rel="stylesheet"
      href="/webjars/bootstrap/5.3.8/css/bootstrap.min.css"
    />
  </head>
  <body>
    <%@ include file="../common/navigation.jspf" %>
    <main class="container mt-4">
      <h1>Create task</h1>
      <p>Please fill-up the following form and submit to create a new task.</p>
      <form:form
        action="/tasks"
        method="post"
        modelAttribute="newTaskRequest"
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
        <div>
          <button type="submit" class="btn btn-success mr-2">Create</button>
          <a href="/tasks" class="btn">Cancel</a>
        </div>
      </form:form>
    </main>
  </body>
</html>
