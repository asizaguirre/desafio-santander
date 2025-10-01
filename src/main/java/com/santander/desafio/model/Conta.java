package com.santander.desafio.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Conta {

    /*
     * Inicialização segura do saldo
     * Validação básica nos métodos depositar e pagar
     * Construtores para flexibilidade na criação de objetos
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;

    private BigDecimal saldo;

    // Construtor padrão
    public Conta() {
        this.saldo = BigDecimal.ZERO;
    }

    // Construtor com parâmetros
    public Conta(Long id, String titular, BigDecimal saldo) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo != null ? saldo : BigDecimal.ZERO;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    // Métodos auxiliares
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            this.saldo = this.saldo.add(valor);
        }
    }

    public boolean pagar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && this.saldo.compareTo(valor) >= 0) {
            this.saldo = this.saldo.subtract(valor);
            return true;
        }
        return false;
    }
}
