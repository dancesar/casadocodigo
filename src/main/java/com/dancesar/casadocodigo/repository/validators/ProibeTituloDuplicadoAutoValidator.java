package com.dancesar.casadocodigo.repository.validators;

import com.dancesar.casadocodigo.entity.Livro;
import com.dancesar.casadocodigo.entity.dto.LivroDTO;
import com.dancesar.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeTituloDuplicadoAutoValidator implements Validator {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return LivroDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        LivroDTO livroDTO = (LivroDTO) target;
        Optional<Livro> possivelTitulo = livroRepository.findByTitulo(livroDTO.getTitulo());

        if (possivelTitulo.isPresent()) {
            errors.rejectValue("titulo", null, "Já existe um livro com esse título", livroDTO.getTitulo());
        }
    }
}
