package com.thiago.bibliotecaGutendex.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
  @ManyToMany(mappedBy = "autor",cascade=CascadeType.ALL)
    private List<Livro> livros = new ArrayList<>();
  public Autor(){}
    public Autor(String nome, Integer anoDeNascimento, Integer anoDeFalecimento){
      this.nome= nome;
      this.anoNascimento =anoDeNascimento;
      this.anoFalecimento=anoDeFalecimento;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getAnoNascimento() { return anoNascimento; }
    public void setAnoNascimento(Integer anoNascimento) { this.anoNascimento = anoNascimento; }

    public Integer getAnoFalecimento() { return anoFalecimento; }
    public void setAnoFalecimento(Integer anoFalecimento) { this.anoFalecimento = anoFalecimento; }

    public List<Livro> getLivros() { return livros; }


}
