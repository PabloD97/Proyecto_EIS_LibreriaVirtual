package com.example.demo.interfaces;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Libro;

@Repository
public interface ILibro extends CrudRepository<Libro,Integer> {
	//codigo nuevo: para la us de busquedad
	@Query("SELECT l FROM Libro l WHERE " + "CONCAT(l.isbn, l.titulo, l.autor, l.edicion, l.genero)" + " LIKE %?1%")
	public List<Libro> findAll(String keyword);

}
