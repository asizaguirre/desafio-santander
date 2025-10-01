package com.santander.desafio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santander.desafio.model.Produto;
import com.santander.desafio.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveListarProdutos() throws Exception {
       Produto p1 = new Produto();
        p1.setId(1L);
        p1.setNome("Notebook");
        p1.setDescricao("Ultrafino");
        p1.setValor(3500.0);

        Produto p2 = new Produto();
        p2.setId(2L);
        p2.setNome("Mouse");
        p2.setDescricao("Sem fio");
        p2.setValor(150.0);

        Produto produto = new Produto();
        produto.setNome("Teclado");
        produto.setDescricao("Mecânico");
        produto.setValor(200.0);

        Produto salvo = new Produto();
        salvo.setId(3L);
        salvo.setNome("Teclado");
        salvo.setDescricao("Mecânico");
        salvo.setValor(200.0);


        when(produtoService.listar()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void deveCriarProduto() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Teclado");
        produto.setDescricao("Mecânico");
        produto.setValor(200.0);

        Produto salvo = new Produto();
        salvo.setId(3L);
        salvo.setNome("Teclado");
        salvo.setDescricao("Mecânico");
        salvo.setValor(200.0);

        when(produtoService.salvar(any())).thenReturn(salvo);

        mockMvc.perform(post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3));
    }
}
