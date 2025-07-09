package com.example.meu_primeiro_springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Olá, mundo!! Bem vinda ao Spring Boot";
	}
}

// src/main/java - onde fica o código da aplicação
// src/main/resources - arquivos de configuração
// src/test/java - teste automatizados

// JPA - comunicação com o banco de dados
// Hibernate - responsavél por traduzir os códigos java em sql
// Spring Data JPA - com ele tem uma redução de operações no banco de dados