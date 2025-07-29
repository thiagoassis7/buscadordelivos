package com.thiago.bibliotecaGutendex.service;

import com.thiago.bibliotecaGutendex.model.Autor;
import com.thiago.bibliotecaGutendex.model.Livro;
import com.thiago.bibliotecaGutendex.repository.AutorRepository;
import com.thiago.bibliotecaGutendex.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class BibliotecaService {
    private final GutendexService gutendexService;
    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;

    public BibliotecaService(GutendexService gutendexService, AutorRepository autorRepository, LivroRepository livroRepository) {
        this.gutendexService = gutendexService;
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    public void buscarLivroPorTitulo(String titulo) {
        titulo = titulo.trim()              // remove espaços no início e fim
                .replaceAll("\\s+", " ") // troca múltiplos espaços por 1 espaço
                .toLowerCase();      // transforma tudo em minúsculas


        var resposta = gutendexService.buscarLivros(titulo);

        if (resposta.getResults().isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }

        // Mostrar resultados numerados
        for (int i = 0; i < resposta.getResults().size(); i++) {
            var livroApi = resposta.getResults().get(i);
            System.out.println((i + 1) + " - " + livroApi.getTitle()
                    + " | Idiomas: " + livroApi.getLanguages()
                    + " | Downloads: " + livroApi.getDownload_count());
        }

        // Escolha do livro para salvar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do livro que deseja salvar (ou 0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= resposta.getResults().size()) {
            var livroEscolhido = resposta.getResults().get(escolha - 1);

            // Pegar primeiro autor
            var autorApi = livroEscolhido.getAuthors().get(0);
            String nomeAutor = (String) autorApi.get("name");
            Integer nascimento = (Integer) autorApi.get("birth_year");
            Integer falecimento = (Integer) autorApi.get("death_year");

            // Verificar se autor já existe no banco
            Object autor = autorRepository.findByNome(nomeAutor)
                    .orElseGet(() -> {
                        Autor novoAutor = new Autor(nomeAutor, nascimento, falecimento);
                        return autorRepository.save(novoAutor);
                    });

            // Criar e salvar livro
            Livro livro = new Livro(
                    livroEscolhido.getTitle(),
                    livroEscolhido.getLanguages().get(0),
                    livroEscolhido.getDownload_count(),
                    autor
            );

            livroRepository.save(livro);

            System.out.println("✅ Livro '" + livro.getTitulo() + "' salvo com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public void listarLivrosRegistrados() {

        livroRepository.findAll().forEach(livro -> {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor().getNome());
        });
    }

    public void listarAutoresRegistrados() {
        autorRepository.findAll().forEach(autor -> {
            System.out.println(autor.getNome() + " (" + autor.getAnoNascimento() + " - " + autor.getAnoFalecimento() + ")");
        });
    }

    public void listarAutoresVivosNoAno(int ano) {
        autorRepository.findAll().stream()
                .filter(autor -> autor.getAnoNascimento() <= ano &&
                        (autor.getAnoFalecimento() == null || autor.getAnoFalecimento() >= ano))
                .forEach(autor -> System.out.println(autor.getNome()));
    }

    public void listarLivrosPorIdioma(String idioma) {
        livroRepository.findAll().stream()
                .filter(livro -> livro.getIdioma().equalsIgnoreCase(idioma))
                .forEach(livro -> System.out.println(livro.getTitulo() + " - " + livro.getAutor().getNome()));
    }

    // Aqui depois a gente adiciona a parte de salvar no banco
    }


