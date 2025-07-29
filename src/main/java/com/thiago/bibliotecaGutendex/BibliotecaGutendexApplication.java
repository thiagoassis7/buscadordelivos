package com.thiago.bibliotecaGutendex;

import com.thiago.bibliotecaGutendex.model.Autor;
import com.thiago.bibliotecaGutendex.model.Livro;
import com.thiago.bibliotecaGutendex.repository.AutorRepository;
import com.thiago.bibliotecaGutendex.repository.LivroRepository;
import com.thiago.bibliotecaGutendex.service.BibliotecaService;
import com.thiago.bibliotecaGutendex.service.GutendexService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class BibliotecaGutendexApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaGutendexApplication.class, args);
	}

	@Bean
	public CommandLineRunner executarMenu(
			GutendexService gutendexService,
			BibliotecaService bibliotecaService) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			int opcao = -1;

			while (opcao != 0) {
				System.out.println("\n=== MENU BIBLIOTECA ===");
				System.out.println("1 - Buscar livro pelo título");
				System.out.println("2 - Listar livros registrados");
				System.out.println("3 - Listar autores registrados");
				System.out.println("4 - Listar autores vivos em determinado ano");
				System.out.println("5 - Listar livros por idioma");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				opcao = scanner.nextInt();
				scanner.nextLine(); // consumir quebra de linha

				switch (opcao) {
					case 1:
						System.out.print("Digite o título do livro: ");
						String titulo = scanner.nextLine();
						bibliotecaService.buscarLivroPorTitulo(titulo);
						break;
					case 2:
						bibliotecaService.listarLivrosRegistrados();
						break;
					case 3:
						bibliotecaService.listarAutoresRegistrados();
						break;
					case 4:
						System.out.print("Digite o ano: ");
						int ano = scanner.nextInt();
						scanner.nextLine();
						bibliotecaService.listarAutoresVivosNoAno(ano);
						break;
					case 5:
						System.out.print("Digite o idioma (ex: pt, en, es): ");
						String idioma = scanner.nextLine();
						bibliotecaService.listarLivrosPorIdioma(idioma);
						break;
					case 0:
						System.out.println("Saindo...");
						break;
					default:
						System.out.println("Opção inválida!");
				}
			}


		};
	}
}
