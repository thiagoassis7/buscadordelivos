📚 Buscador de Livros - Integração com API Gutendex
📌 Sobre o Projeto

O Buscador de Livros é uma aplicação backend desenvolvida em Java com Spring Boot que consome a API pública Gutendex para buscar e organizar informações sobre livros do Projeto Gutenberg.

A aplicação realiza requisições HTTP para a API externa, processa os dados recebidos e os disponibiliza por meio de endpoints REST.

Este projeto foi desenvolvido com foco em prática de:

Consumo de API REST

Organização em camadas (Controller → Service)

Tratamento de dados

Estruturação de projeto backend com Spring Boot

🚀 Tecnologias Utilizadas

Java

Spring Boot

Maven

API REST

HTTP Client (RestTemplate/WebClient)

Git

🏗️ Estrutura do Projeto

O projeto segue organização em camadas:

controller  →  Recebe as requisições HTTP
service     →  Contém a lógica de negócio
model       →  Representa as entidades/dados


Essa separação facilita manutenção, testes e escalabilidade.

🔎 Funcionalidades

Buscar livros por título

Consumir dados diretamente da API Gutendex

Processar e retornar informações estruturadas

🌐 API Externa Utilizada

Gutendex API
https://gutendex.com/

▶️ Como Executar o Projeto
1️⃣ Clonar o repositório
git clone https://github.com/thiagoassis7/buscadordelivos.git

2️⃣ Acessar a pasta do projeto
cd buscadordelivos

3️⃣ Executar a aplicação

Se estiver usando Maven:

mvn spring-boot:run


Ou executar pela sua IDE (IntelliJ / Eclipse).

🧪 Testando a Aplicação

Após iniciar o projeto, utilize:

Postman
ou

Navegador

Para acessar os endpoints disponíveis (exemplo):

http://localhost:8080/{endpoint}


(Substitua {endpoint} pela rota implementada no Controller.)

🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco em aprimorar conhecimentos em:

Desenvolvimento backend com Java

Arquitetura em camadas

Integração com APIs externas

Estruturação de aplicações Spring Boot
