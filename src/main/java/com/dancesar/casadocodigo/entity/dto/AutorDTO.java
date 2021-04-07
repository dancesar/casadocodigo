package com.dancesar.casadocodigo.entity.dto;

import com.dancesar.casadocodigo.entity.Autor;
import lombok.Data;

@Data
public class AutorDTO {

    private String nome;
    private String email;
    private String descricao;

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}