package com.dancesar.casadocodigo.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoriaDTO {

    private Integer id;

    @NotBlank(message = "Informe o nome da categoria.")
    private String nome;

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
