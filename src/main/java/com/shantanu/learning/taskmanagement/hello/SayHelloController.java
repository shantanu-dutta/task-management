package com.shantanu.learning.taskmanagement.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class SayHelloController {

  @GetMapping()
  @ResponseBody
  public String sayHello() {
    return """
        <!DOCTYPE html>
        <html lang="en">
        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Sample page</title>
        </head>
        <body>
          <main>
            <h1>Sample page</h1>
            <p>This is a sample page.</p>
          </main>
        </body>
        </html>
        """;
  }
}
