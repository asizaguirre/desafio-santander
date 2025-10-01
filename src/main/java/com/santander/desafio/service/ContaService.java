package com.santander.desafio.service;

import com.santander.desafio.model.Conta;
import com.santander.desafio.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public void depositar(Long id, BigDecimal valor) {
        Conta conta = contaRepository.findById(id).orElseThrow();
        conta.depositar(valor);
        contaRepository.save(conta);
    }

    public BigDecimal consultarSaldo(Long id) {
        Conta conta = contaRepository.findById(id).orElseThrow();
        return conta.getSaldo();
    }

    public void pagarConta(Long id, BigDecimal valor) {
        Conta conta = contaRepository.findById(id).orElseThrow();
        if (!conta.pagar(valor)) {
            throw new RuntimeException("Saldo insuficiente para pagamento.");
        }
        contaRepository.save(conta);
    }
}
