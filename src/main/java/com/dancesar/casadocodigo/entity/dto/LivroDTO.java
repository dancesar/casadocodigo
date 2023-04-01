package com.dancesar.casadocodigo.entity.dto;

import com.dancesar.casadocodigo.entity.Autor;
import com.dancesar.casadocodigo.entity.Categoria;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LivroDTO {

    private Integer id;
    @NotBlank(message = "Informe o título do livro.")
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String isbn;
    private LocalDateTime dtPublicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroDTO(Integer id, String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String isbn, LocalDateTime dtPublicacao, Categoria categoria, Autor autor) {
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
