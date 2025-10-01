package com.santander.desafio.controller;

import com.santander.desafio.service.ContaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContaService contaService;

    @Test
    public void testDepositar() throws Exception {
        mockMvc.perform(post("/conta/depositar")
                .param("id", "1")
                .param("valor", "100.00"))
                .andExpect(status().isOk())
                .andExpect(content().string("Depósito realizado com sucesso."));
    }

    @Test
    public void testConsultarSaldo() throws Exception {
        when(contaService.consultarSaldo(1L)).thenReturn(new BigDecimal("250.00"));

        mockMvc.perform(get("/conta/saldo")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("250.00"));
    }

    @Test
    public void testPagarConta() throws Exception {
        mockMvc.perform(post("/conta/pagar")
                .param("id", "1")
                .param("valor", "50.00"))
                .andExpect(status().isOk())
                .andExpect(content().string("Pagamento realizado com sucesso."));
    }
}
