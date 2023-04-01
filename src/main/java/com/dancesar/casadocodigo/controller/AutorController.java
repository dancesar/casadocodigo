package com.dancesar.casadocodigo.controller;

import com.dancesar.casadocodigo.entity.dto.AutorDTO;
import com.dancesar.casadocodigo.service.irepository.ServiceAutor;
import com.dancesar.casadocodigo.utils.validators.ProibeEmailDuplicadoAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private ServiceAutor iAutorService;

    @Autowired
    ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<Boolean> createAuthor(@RequestBody @Valid AutorDTO autorDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.iAutorService.cadastrarAutor(autorDTO));
    }
}
