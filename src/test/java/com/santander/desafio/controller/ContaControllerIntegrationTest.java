package com.santander.desafio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContaControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testConsultarSaldo() {
        ResponseEntity<BigDecimal> response = restTemplate.getForEntity("/conta/saldo?id=1", BigDecimal.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDepositar() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>("id=1&valor=100.00", headers);
        ResponseEntity<String> response = restTemplate.postForEntity("/conta/depositar", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Depósito realizado com sucesso.", response.getBody());
    }

    @Test
    public void testPagarConta() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>("id=1&valor=50.00", headers);
        ResponseEntity<String> response = restTemplate.postForEntity("/conta/pagar", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pagamento realizado com sucesso.", response.getBody());
    }
}
