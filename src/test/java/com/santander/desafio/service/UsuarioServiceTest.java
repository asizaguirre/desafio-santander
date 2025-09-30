package com.santander.desafio.service;

import com.santander.desafio.model.Usuario;
import com.santander.desafio.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    private UsuarioRepository repository;
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        repository = mock(UsuarioRepository.class);
        service = new UsuarioService(repository);
    }

    @Test
    void deveSalvarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Alam");
        usuario.setEmail("alam@email.com");
        usuario.setCpf("12345678900");

        when(repository.save(usuario)).thenReturn(usuario);

        Usuario salvo = service.salvar(usuario);
        assertEquals("Alam", salvo.getNome());
        verify(repository, times(1)).save(usuario);
    }

    @Test
    void deveListarUsuarios() {
        when(repository.findAll()).thenReturn(List.of(new Usuario(), new Usuario()));
        List<Usuario> lista = service.listar();
        assertEquals(2, lista.size());
        verify(repository, times(1)).findAll();
    }
}
