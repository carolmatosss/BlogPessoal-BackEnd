package com.blogPessoal.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogPessoal.blogpessoal.model.Postagem;

@Repository //Classe que define os padrões de interação com o banco de dados, através das linguagens do mysql
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
//Aqui estamos mapeando para o banco de dados, onde o Long se refere a nossa Primary Key
	
	// Classe abstrata composta por métodos que serão implementados em uma classe
}
