package com.dancesar.casadocodigo.controller;

import com.dancesar.casadocodigo.entity.dto.CategoriaDTO;
import com.dancesar.casadocodigo.repository.validators.ProibeCategoriaDuplicadoCategoriaValidator;
import com.dancesar.casadocodigo.service.irepository.ServiceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private ServiceCategoria iServiceCategoria;

    @Autowired
    private ProibeCategoriaDuplicadoCategoriaValidator proibeNomeDuplicadoNomeValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(proibeNomeDuplicadoNomeValidator);
    }

    @PostMapping
    public ResponseEntity<Boolean> createCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.iServiceCategoria.cadastrarCategoria(categoriaDTO));
    }
}
