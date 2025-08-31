<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login - Task Management</title>
  </head>
  <body>
    <main>
      <h1>Login</h1>
      <p>Welcome to the login page!</p>
      <form action="/login" method="post">
        <div>
          <label for="name">Name</label>
          <input type="text" id="name" name="name">
        </div>
        <div>
          <label for="password">Password</label>
          <input type="password" name="password" id="password">
        </div>
        ${errorMessage}
        <div>
          <button type="submit">Submit</button>
        </div>
      </form>
    </main>
  </body>
</html>
