package com.blogPessoal.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogPessoal.blogpessoal.model.Postagem;

@Repository //Classe que define os padrões de interação com o banco de dados, através das linguagens do mysql
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	//Aqui estamos mapeando para o banco de dados, onde o Long se refere a nossa Primary Key

	// Classe abstrata composta por métodos que serão implementados em uma classe
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	//Metodo public que trata uma lista de postagem e só serão buscados as infos do titulo. Isso está fora do JPA, por isso a lógica
	//cria-se aqui
}
