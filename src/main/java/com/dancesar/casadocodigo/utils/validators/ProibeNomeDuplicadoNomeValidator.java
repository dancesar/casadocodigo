package com.dancesar.casadocodigo.utils.validators;

import com.dancesar.casadocodigo.entity.Categoria;
import com.dancesar.casadocodigo.entity.dto.CategoriaDTO;
import com.dancesar.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicadoNomeValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaDTO categoriaDTO = (CategoriaDTO) target;
        Optional<Categoria> possivelNome = categoriaRepository.findByNome(categoriaDTO.getNome());

        if(possivelNome.isPresent()){
            errors.rejectValue("nome", null, "Já existe um(a) outro(a) nome(a) para esta categoria " + categoriaDTO.getNome());
        }
    }
}
