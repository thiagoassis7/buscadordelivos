package com.thiago.bibliotecaGutendex.repository;

import com.thiago.bibliotecaGutendex.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository <Autor,Long>{

    Optional<Autor> findByNome(String nome);
}
