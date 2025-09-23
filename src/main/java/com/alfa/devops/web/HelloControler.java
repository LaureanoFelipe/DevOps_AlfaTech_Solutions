package com.alfa.devops.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

  @Value("${app.message:Demo pronta!}")
  private String message;

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(defaultValue = "world") String name) {
    String envMsg = System.getenv().getOrDefault("MENSAGEM", message);
    return "Hello, " + name + "! " + envMsg;
  }
}