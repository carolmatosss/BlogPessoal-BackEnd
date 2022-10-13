package com.blogPessoal.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.blogPessoal.blogpessoal.model.Postagem;
import com.blogPessoal.blogpessoal.repository.PostagemRepository;
import com.blogPessoal.blogpessoal.repository.TemaRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //Para que o FrontEnd consuma a API. Pra não limitar a porta, para liberar as rotas para outras plataformas. 
public class PostagemController {

	@Autowired //A Injeção de Dependência define quais Classes serão instanciadas e em quais lugares serãoInjetadas quando houver necessidade.
	private PostagemRepository postagemRepository;// A Injeção de dependencia é a injeção da repository que conversa com a JPA que conversa com o banco de dados
	//Traz o repositório que está extendo os método do JPA
	
	@Autowired 
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>>getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long id){ //Requisição na tabela o caminho é o Id
		return postagemRepository.findById(id).map(resposta->ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	//Aqui é para quando tivermos uma resposta é para vir um ok
	//-> Lambda acessa o método de forma resumida, uma função anonima que não cria necesidade de criar toda a lógica, resume para nos
	//O else nos trás a resposta caso não seja encontrado a resposta que é um Http Status de não encontrado

	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem){
		if (temaRepository.existsById(postagem.getTema().getId())) 
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		//Método post para realizar uma postagem
	}

	@PutMapping
	public ResponseEntity <Postagem> put (@Valid @RequestBody Postagem postagem){
		if (postagemRepository.existsById(postagem.getId())) {
			if (temaRepository.existsById(postagem.getTema().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	//Método put semelhante ao método post, a diferenca é que id precisa existir
	
	
@ResponseStatus
@DeleteMapping("/{id}")
public void delete (@PathVariable Long id) {
	Optional <Postagem> postagem = postagemRepository.findById(id);
	
	if (postagem.isEmpty())
		throw new ResponseStatusException (HttpStatus.NOT_FOUND);
	
postagemRepository.deleteById(id);
	
	//Metodo delete deletando tudo a partir da inserção do Id no Endpoint
	
}

}
