package com.dancesar.casadocodigo.repository;

import com.dancesar.casadocodigo.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
