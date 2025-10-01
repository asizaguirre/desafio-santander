package com.santander.desafio.controller;

import com.santander.desafio.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/depositar")
    public ResponseEntity<String> depositar(@RequestParam Long id, @RequestParam BigDecimal valor) {
        contaService.depositar(id, valor);
        return ResponseEntity.ok("Depósito realizado com sucesso.");
    }

    @GetMapping("/saldo")
    public ResponseEntity<BigDecimal> consultarSaldo(@RequestParam Long id) {
        return ResponseEntity.ok(contaService.consultarSaldo(id));
    }

    @PostMapping("/pagar")
    public ResponseEntity<String> pagarConta(@RequestParam Long id, @RequestParam BigDecimal valor) {
        contaService.pagarConta(id, valor);
        return ResponseEntity.ok("Pagamento realizado com sucesso.");
    }
}
