package com.thiago.bibliotecaGutendex.model;

import jakarta.persistence.*;

@Entity
@Table(name ="livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private Integer downloadCount;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


    public Livro(String titulo, String idioma, Integer downLoadCount) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.downloadCount = downLoadCount;



    }

    public Livro(String title, String idioma, int downloadCount, Object autor) {
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}


