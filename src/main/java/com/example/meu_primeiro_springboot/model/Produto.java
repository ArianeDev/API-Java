package com.example.meu_primeiro_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // entidade jpa
@Table(name = "produtos") // nome da tabela
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // o id vai ser uma chave primaria que será criada automaticamente
	private Long id;

	private String nome;
	private Double preco;

	public Produto() {}

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
