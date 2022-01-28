package com.dancesar.casadocodigo.repository;

import com.dancesar.casadocodigo.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AutorRepository extends JpaRepository <Autor, Long> {

    Optional<Autor> findbyEmail(String email);
}
