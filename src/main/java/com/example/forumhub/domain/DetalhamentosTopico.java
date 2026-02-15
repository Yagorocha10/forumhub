package com.example.forumhub.domain;

import java.time.LocalDateTime;

public record DetalhamentosTopico(
       Long id,
       String titulo,
       String mensagem,
       LocalDateTime dataCriacao,
       EstadoTopico estadoTopico,
       String autor,
       String curso
) {

    public DetalhamentosTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoTopico(), topico.getAutor(), topico.getCurso());
    }
}
