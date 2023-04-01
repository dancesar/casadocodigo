package com.dancesar.casadocodigo.utils.validators;

import com.dancesar.casadocodigo.entity.Livro;
import com.dancesar.casadocodigo.entity.dto.LivroDTO;
import com.dancesar.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeIsbnDuplicadoLivroValidator implements Validator {

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
        Optional<Livro> possivelIsbn = livroRepository.findByISBN(livroDTO.getIsbn());

        if (possivelIsbn.isPresent()) {
            errors.rejectValue("ISBN", null, "Já existe um ISBN com esse título" + livroDTO.getIsbn());
        }
    }
}
