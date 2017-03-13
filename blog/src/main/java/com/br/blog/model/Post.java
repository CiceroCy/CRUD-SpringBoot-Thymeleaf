package com.br.blog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="tbl_post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name = "post_seq",sequenceName="post_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="post_seq")
	private Long id;
	
	@Column(nullable=false,length=50)
	@NotBlank(message="Autor é uma informação Obrigatoria")
	private String autor;
	
	@Column(nullable=false,length=150)
	@NotBlank(message="O Titulo é uma informação Obrigatoria")
	private String titulo;
	
	@Column(nullable=false,length=2000)
	@NotBlank(message="O Texto é uma informação Obrigatoria")
	private String texto;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	
}
