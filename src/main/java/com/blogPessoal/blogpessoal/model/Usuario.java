package com.blogPessoal.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table (name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank (message = "obrigatorio")
	@Size(min=2 , max=20)
	private String nome;

	private String foto; 

	@Schema(example = "email@email.com.br") //Para quw apareça uma mensagem de exemplo no swagger
	@NotBlank
	@Email (message= "Informe um e-mail válido")
	private String usuario;

	@NotBlank (message = "Ela é obrigatória")
	@Size (min=8, message= "A senha deve ter no mínimo 8 caracteres")
	private String senha;

	@OneToMany (mappedBy= "usuario" , cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties  ("usuario")
	public List<Postagem>  postagem;




	public Usuario(Long id, String nome, String foto, String usuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.usuario = usuario;
		this.senha = senha;
	}


	public Usuario() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}


}
