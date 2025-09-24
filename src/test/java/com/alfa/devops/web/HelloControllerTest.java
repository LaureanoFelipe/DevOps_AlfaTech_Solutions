package com.alfa.devops.web;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

  @Test
  void pingDeveRetornarPong() {
    HelloController c = new HelloController();
    String resp = c.ping();
    assertEquals("pong", resp);
  }
}