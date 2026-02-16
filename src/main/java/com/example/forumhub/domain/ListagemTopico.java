package com.example.forumhub.domain;

import java.time.LocalDateTime;

public record ListagemTopico(String titulo,
                             String mensagem,
                             LocalDateTime dataCriacao,
                             EstadoTopico estadoTopico,
                             String autor,
                             String curso

) {

    public ListagemTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoTopico(), topico.getAutor(), topico.getCurso());
    }
}
