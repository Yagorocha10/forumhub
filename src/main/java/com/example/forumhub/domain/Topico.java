package com.example.forumhub.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;
    private String autor;
    private String curso;

    public Topico() {
    }

    public Topico(CadastroTopico cadastroTopico) {
        this.titulo = cadastroTopico.titulo();
        this.mensagem = cadastroTopico.mensagem();
        this.dataCriacao =  cadastroTopico.dataCriacao();
        this.estadoTopico = cadastroTopico.estadoTopico();
        this.autor = cadastroTopico.autor();
        this.curso = cadastroTopico.curso();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public EstadoTopico getEstadoTopico() {
        return estadoTopico;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public void atualizarInformacoes(AtualizacaoTopico atualizacaoTopico) {


        if (atualizacaoTopico.titulo() != null) {
            this.titulo = atualizacaoTopico.titulo();
        }

        if (atualizacaoTopico.mensagem() != null) {
            this.mensagem = atualizacaoTopico.mensagem();
        }

        if (atualizacaoTopico.dataCriacao() != null) {
            this.dataCriacao = atualizacaoTopico.dataCriacao();
        }

        if (atualizacaoTopico.autor() != null) {
            this.autor = atualizacaoTopico.autor();
        }

        if (atualizacaoTopico.curso() != null) {
            this.curso = atualizacaoTopico.curso();
        }


    }
}
