package com.blogPessoal.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity //Entidade que transforma em tabela no banco
@Table(name="tb_postagens") //Para dar nome na tabela
public class Postagem {

	@Id //essa variável será ID no banco de dados. Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Estratégia para gerar identidade automática
	private Long id; // Criando a bigint 
	
	@NotBlank
	@Size(min = 5, max =50)
	private String titulo;
	
	@NotBlank //com notnull não pode deixar de passar o dado quando for cadastrar
	//mas o usuário pode tentar burlar e ai o notblank obriga a 
	//digitar alguma coisa ai não só um espaço em branco

	@Size (min= 5, max=50)
	private String texto;
	
	@UpdateTimestamp
	private LocalDate data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	} 
	
	
}
