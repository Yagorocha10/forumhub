package com.example.forumhub.controller;


import com.example.forumhub.security.DadosTokenJWT;
import com.example.forumhub.security.TokenService;
import com.example.forumhub.usuario.DadosAutenticacao;
import com.example.forumhub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {

       var tokenSpring =  new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
       var authentication = authenticationManager.authenticate(tokenSpring);

       var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

       return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));


    }












}
