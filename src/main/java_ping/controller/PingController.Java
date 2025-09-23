package com.github.acnaweb.java_ping.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ping")
public class PingController { 

    @Value("${MENSAGEM:Mensagem default}")
    private String mensagem;

    @GetMapping
    public String ping() {
        return "pong";
    }

    @GetMapping("/mensagem")
    public String mensagem() {
        return mensagem;
    }
}