package com.example.forumhub.domain;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Struct;
import java.time.LocalDateTime;

public record AtualizacaoTopico(
                                @NotNull
                                Long id,
                                @NotBlank
                                String titulo,
                                @NotBlank
                                String mensagem,
                                @NotNull
                                @Future
                                LocalDateTime dataCriacao,
                                @NotNull
                                EstadoTopico estadoTopico,
                                @NotBlank
                                String autor,
                                @NotBlank
                                String curso


) {
}
