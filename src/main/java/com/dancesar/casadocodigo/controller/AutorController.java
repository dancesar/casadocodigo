package com.dancesar.casadocodigo.controller;

import com.dancesar.casadocodigo.entity.Autor;
import com.dancesar.casadocodigo.entity.dto.AutorDTO;
import com.dancesar.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDTO> createAuthor(@RequestBody @Valid AutorDTO autorDTO){
        Autor autor = autorDTO.converter();
        autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.OK).body(autorDTO);
    }
}
