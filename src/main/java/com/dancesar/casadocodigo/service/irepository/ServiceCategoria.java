package com.dancesar.casadocodigo.service.irepository;

import com.dancesar.casadocodigo.entity.dto.CategoriaDTO;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCategoria {

    public Boolean cadastrarCategoria(final CategoriaDTO categoriaDTO);
}
