package com.blogPessoal.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.blogpessoal.model.Postagem;
import com.blogPessoal.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //Para que o FrontEnd consuma a API
public class PostagemController {
	
	@Autowired //A Injeção de Dependência define quais Classes serão instanciadas e em quais lugares serãoInjetadas quando houver necessidade.
	private PostagemRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<Postagem>>getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}

}
