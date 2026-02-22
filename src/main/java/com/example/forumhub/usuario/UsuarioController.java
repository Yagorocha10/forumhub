package com.example.forumhub.usuario;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity criacaoDeUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = new Usuario(dadosCadastroUsuario);
        usuarioRepository.save(usuario);

        var uri = uriComponentsBuilder.path("/usuarios")
                .buildAndExpand(usuario.getId()).toUri();


        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }












}
