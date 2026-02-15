package com.example.forumhub.controller;

import com.example.forumhub.domain.CadastroTopico;
import com.example.forumhub.domain.DetalhamentosTopico;
import com.example.forumhub.domain.Topico;
import com.example.forumhub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastroDeTopico(@RequestBody @Valid CadastroTopico cadastroTopico, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(cadastroTopico);
        topicoRepository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentosTopico(topico));

    }




}
