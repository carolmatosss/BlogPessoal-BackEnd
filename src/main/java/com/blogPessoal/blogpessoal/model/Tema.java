package com.blogPessoal.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_temas")
public class Tema {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade =CascadeType.REMOVE)// tirar o ALL e por o REMOVE
    //Essa anotação é feita para caso eu apague um tema, também seja apagado as postagens cadstradas, pois caso eu procure uma postagem sem tema, dará erro no meu banco de dados
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;  //A postagem é em lista, porque são muitas postagens

	
	
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
