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

  @GetMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
  public String hello(
      @RequestParam(name = "name", required = false, defaultValue = "world") String name) {
    String envMsg = System.getenv().getOrDefault("MENSAGEM", message);
    return "Hello, " + name + "! " + envMsg;
  }
}