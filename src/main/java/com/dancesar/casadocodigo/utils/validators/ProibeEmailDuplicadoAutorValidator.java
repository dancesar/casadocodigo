package com.dancesar.casadocodigo.utils.validators;

import com.dancesar.casadocodigo.entity.Autor;
import com.dancesar.casadocodigo.entity.dto.AutorDTO;
import com.dancesar.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorDTO autorDTO = (AutorDTO) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(autorDTO.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "Já existe um(a) outro(a) autor(a) com o mesmo e-mail " + autorDTO.getEmail());
        }
    }
}
