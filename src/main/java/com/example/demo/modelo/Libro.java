package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int isbn;
	private String titulo;
	private String autor;
	private int edicion;
	private String genero;
	private int stock;
	private String foto;
	
	
	
	public Libro() {
		super();
	}


	public Libro(int isbn, String titulo, String autor, int edicion, String genero, int stock,String foto) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.edicion = edicion;
		this.genero = genero;
		this.stock = stock;
		this.foto = foto;
	}




	public int getIsbn() {
		return isbn;
	}



	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public int getEdicion() {
		return edicion;
	}



	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
	
}
