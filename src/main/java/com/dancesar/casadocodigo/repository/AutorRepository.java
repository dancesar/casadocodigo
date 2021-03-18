package com.dancesar.casadocodigo.repository;

import com.dancesar.casadocodigo.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
