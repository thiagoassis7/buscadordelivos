package com.thiago.bibliotecaGutendex.repository;

import com.thiago.bibliotecaGutendex.model.Autor;
import com.thiago.bibliotecaGutendex.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro,Long >{
    Boolean existsByTituloAndAutor(String titulo , Autor autor);
}
