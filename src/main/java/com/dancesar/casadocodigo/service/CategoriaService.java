package com.dancesar.casadocodigo.service;

import com.dancesar.casadocodigo.entity.Categoria;
import com.dancesar.casadocodigo.entity.dto.CategoriaDTO;
import com.dancesar.casadocodigo.repository.CategoriaRepository;
import com.dancesar.casadocodigo.service.irepository.ServiceCategoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ServiceCategoria {

    private CategoriaRepository categoriaRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.modelMapper = new ModelMapper();
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Boolean cadastrarCategoria(CategoriaDTO categoriaDTO){
        try {
            Categoria categoriaEntity = this.modelMapper.map(categoriaDTO, Categoria.class);
            this.categoriaRepository.save(categoriaEntity);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
