package com.dancesar.casadocodigo.controller;

import com.dancesar.casadocodigo.entity.dto.LivroDTO;
import com.dancesar.casadocodigo.service.irepository.ServiceLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class LivroController {

    @Autowired
    private ServiceLivro iServiceLivro;

    @PostMapping
    public ResponseEntity<Boolean> createLivro(@RequestBody @Valid LivroDTO livroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.iServiceLivro.cadastrarLivro(livroDTO));
    }
}
