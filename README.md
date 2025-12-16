Padaria Master – API Backend

Este repositório contém o backend da Padaria Master, uma aplicação desenvolvida em Java com Spring Boot, focada no gerenciamento de usuários, padarias e compras, com segurança integrada via Spring Security.

📌 Funcionalidades

👤 Cadastro e autenticação de usuários

🔐 Criptografia de senha com BCrypt

🏪 Cadastro e gerenciamento de padarias

🛒 Registro de compras

🛡️ Controle de acesso com Spring Security

📦 Arquitetura em camadas (Controller, Service, Repository, DTO)

🛠️ Tecnologias Utilizadas

Java 17

Spring Boot

Spring Security

Spring Data JPA

MySQL

Maven

Postman (para testes da API)
Segurança

A aplicação utiliza Spring Security para proteger as rotas.

Rotas públicas:

/auth/**

/cadastros/**

Rotas privadas:

Demais endpoints exigem autenticação

As senhas são armazenadas de forma segura usando BCryptPasswordEncoder.

🧪 Testes

Os endpoints podem ser testados utilizando o Postman.

Para autenticação, utilize Basic Auth:

Usuário: email cadastrado

Senha: senha cadastrada
