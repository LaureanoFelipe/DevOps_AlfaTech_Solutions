package com.github.acnaweb.java_ping.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(PingController.class)
class PingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Caso o @Value use algo que não esteja setado por ambiente nos testes, você pode mockar um @Bean, se necessário.
    // Aqui, vamos simular o ambiente de teste com "pong!" diretamente.
    
    @Test
    void testGivenRequest_whenGetInfo_thenResponse() throws Exception {
        ResultActions response = mockMvc.perform(get("/ping")
            .header("MENSAGEM", "pong!")); // apenas ilustrativo, já que @Value não lê headers

        response.andExpect(content().string("pong"));
    }

    @Test
    void testGivenRequest_whenGetInfo_thenHttp200() throws Exception {
        ResultActions response = mockMvc.perform(get("/ping")
            .header("MENSAGEM", "pong!")); // apenas ilustrativo, já que @Value não lê headers

        response.andExpect(status().isOk());
    }
}