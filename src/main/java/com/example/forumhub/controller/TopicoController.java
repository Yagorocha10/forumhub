package com.example.forumhub.controller;

import com.example.forumhub.domain.*;
import com.example.forumhub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
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

    @GetMapping
    public Page<ListagemTopico> listagemTopicos(@PageableDefault(size = 10, sort = {"titulo"})  Pageable paginacao) {
        return topicoRepository.findAll(paginacao).map(ListagemTopico::new);


    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTopicoPorId(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentosTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopico atualizacaoTopico) {
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(atualizacaoTopico);

        return ResponseEntity.ok(new DetalhamentosTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();


    }



}
