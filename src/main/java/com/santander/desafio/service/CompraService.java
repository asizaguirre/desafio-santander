package com.santander.desafio.service;

import com.santander.desafio.model.Compra;
import com.santander.desafio.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    public Compra salvar(Compra compra) {
        return repository.save(compra);
    }

    public List<Compra> listar() {
        return repository.findAll();
    }
}
