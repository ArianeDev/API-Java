package com.example.meu_primeiro_springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Long id) { // torna opcional pq pode ou não retonar produtos
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Produto com o ID "+id+" não encontrado"));
	}

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void deletarProduto(Long id) {
		if(!produtoRepository.existsById(id)) {
			throw new RecursoNaoEncontradoException("Produto com o ID "+id+" não encontrado");
		}
		produtoRepository.deleteById(id);
	}
}

// regras de negócios
// processa os dados antes de salvar ou retonar
// métodos reutilizaveis

// Não acessar diretamente a camada controller