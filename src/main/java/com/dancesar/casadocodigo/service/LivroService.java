package com.dancesar.casadocodigo.service;

import com.dancesar.casadocodigo.entity.Livro;
import com.dancesar.casadocodigo.entity.dto.LivroDTO;
import com.dancesar.casadocodigo.repository.LivroRepository;
import com.dancesar.casadocodigo.service.irepository.ServiceLivro;
import org.modelmapper.ModelMapper;

public class LivroService implements ServiceLivro {

    private LivroRepository livroRepository;

    private ModelMapper modelMapper;

    public LivroService(LivroRepository livroRepository, ModelMapper modelMapper) {
        this.livroRepository = livroRepository;
        this.modelMapper = modelMapper;
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
