package com.dancesar.casadocodigo.repository;

import com.dancesar.casadocodigo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
