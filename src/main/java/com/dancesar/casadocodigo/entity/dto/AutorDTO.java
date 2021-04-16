package com.dancesar.casadocodigo.entity.dto;

import com.dancesar.casadocodigo.entity.Autor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AutorDTO {

    private Integer id;

    @NotBlank(message = "Informe o nome do Autor.")
    private String nome;

    @Email(message = "E-mail invalido.")
    private String email;

    @NotBlank(message = "Informe uma descrição.")
    @Size(max = 400)
    private String descricao;

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}