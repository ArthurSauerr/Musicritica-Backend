package com.Musicritica.VictorArthurGabriel.controller;

import com.Musicritica.VictorArthurGabriel.entity.Usuario;
import com.Musicritica.VictorArthurGabriel.exception.MusicriticaException;
import com.Musicritica.VictorArthurGabriel.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario salvar(@RequestBody Usuario novoUsuario) throws MusicriticaException {
        return service.salvar(novoUsuario);
    }
    @GetMapping(value = "/{id}")
    public Usuario buscarPeloId(@PathVariable Long id) { return service.buscarId(id); }

    @PutMapping
    public boolean atualizar(@RequestBody Usuario usuario) throws MusicriticaException{
        return service.atualizar(usuario) != null;
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id){
        return service.excluir(id);
    }

}