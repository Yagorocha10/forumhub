package com.example.forumhub.usuario;

public record DadosDetalhamentoUsuario(String login,
                                       String senha) {



    DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getLogin(), usuario.getSenha());


    }



}
