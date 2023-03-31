package com.dancesar.casadocodigo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
public class Livro implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String isbn;
    private LocalDateTime dtPublicacao;
    private Categoria categoria;
    private Autor autor;

    public Livro(Integer id, String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String isbn, LocalDateTime dtPublicacao, Categoria categoria, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dtPublicacao = dtPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}