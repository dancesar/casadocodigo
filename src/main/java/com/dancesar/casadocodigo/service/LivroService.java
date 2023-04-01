package com.dancesar.casadocodigo.service;

import com.dancesar.casadocodigo.entity.Livro;
import com.dancesar.casadocodigo.entity.dto.LivroDTO;
import com.dancesar.casadocodigo.repository.LivroRepository;
import com.dancesar.casadocodigo.service.irepository.ServiceLivro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService implements ServiceLivro {

    private LivroRepository livroRepository;

    private ModelMapper modelMapper;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Boolean cadastrarLivro(LivroDTO livroDTO) {
        try {
            Livro livroEntity = this.modelMapper.map(livroDTO, Livro.class);
            this.livroRepository.save(livroEntity);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
