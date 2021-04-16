package com.dancesar.casadocodigo.controller;

import com.dancesar.casadocodigo.entity.dto.AutorDTO;
import com.dancesar.casadocodigo.repository.AutorRepository;
import com.dancesar.casadocodigo.service.irepository.ServiceAutor;
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

    @Autowired
    private ServiceAutor iAutorService;

    @PostMapping
    public ResponseEntity<Boolean> createAuthor(@RequestBody @Valid AutorDTO autorDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.iAutorService.cadastrarAutor(autorDTO));
    }
}
