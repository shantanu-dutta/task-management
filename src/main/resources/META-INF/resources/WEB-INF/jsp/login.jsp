<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login - Task Management</title>
    <link
      rel="stylesheet"
      href="/webjars/bootstrap/5.3.8/css/bootstrap.min.css"
    />
  </head>
  <body>
    <%@ include file="./common/navigation.jspf" %>
    <main class="container mt-4">
      <h1>Login</h1>
      <p>Welcome to the login page!</p>
      <form action="/login" method="post">
        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input type="text" class="form-control" id="name" name="name" />
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input
            type="password"
            class="form-control"
            name="password"
            id="password"
          />
        </div>
        ${errorMessage}
        <div>
          <button type="submit" class="btn btn-primary">Login</button>
        </div>
      </form>
    </main>
  </body>
</html>
