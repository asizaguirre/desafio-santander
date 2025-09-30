package com.santander.desafio.controller;

import com.santander.desafio.model.Compra;
import com.santander.desafio.service.CompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping
    public Compra criar(@RequestBody Compra compra) {
        return service.salvar(compra);
    }

    @GetMapping
    public List<Compra> listar() {
        return service.listar();
    }
}
