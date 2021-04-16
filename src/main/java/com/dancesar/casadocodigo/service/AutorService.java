package com.dancesar.casadocodigo.service;

import com.dancesar.casadocodigo.entity.Autor;
import com.dancesar.casadocodigo.entity.dto.AutorDTO;
import com.dancesar.casadocodigo.repository.AutorRepository;
import com.dancesar.casadocodigo.service.irepository.ServiceAutor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements ServiceAutor {

    private AutorRepository autorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.modelMapper = new ModelMapper();
        this.autorRepository = autorRepository;
    }

    @Override
    public Boolean cadastrarAutor(AutorDTO autorDTO) {
        try {
            Autor autorEntity = this.modelMapper.map(autorDTO, Autor.class);
            this.autorRepository.save(autorEntity);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}