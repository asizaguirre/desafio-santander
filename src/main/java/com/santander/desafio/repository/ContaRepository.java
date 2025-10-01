package com.santander.desafio.repository;

import com.santander.desafio.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {}
