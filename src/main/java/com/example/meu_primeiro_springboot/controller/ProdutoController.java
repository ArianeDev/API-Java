package com.example.meu_primeiro_springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.service.ProdutoService;

@RestController
@RequestMapping("api/produtos") //endpoint
public class ProdutoController {
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping()
	public List<Produto> getProdutos() {
		return produtoService.listarProdutos();
	} 

	@GetMapping("/{id}")
	public ResponseEntity<?> getProduto(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		return ResponseEntity.ok(produto);
	}

	@PostMapping
	public Produto postProduto(@RequestBody Produto produto) { // boa prática: retonar o objeto criado
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
}

// métodos 
// endpoints
// chamar métodos da serice para realizar a lógica

// Não colocra regras de negócio
//  Não acessar o banco diretamente
