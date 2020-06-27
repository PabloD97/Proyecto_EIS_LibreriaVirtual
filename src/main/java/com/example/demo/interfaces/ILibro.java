package com.example.demo.interfaces;


import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Libro;

@Repository
public interface ILibro extends JpaRepository<Libro,Integer>  {
	
	
	//codigo nuevo: para la us de busquedad
	@Query("SELECT l FROM Libro l WHERE " + "CONCAT(l.isbn, l.titulo, l.autor, l.edicion, l.genero)" + " LIKE %?1%")
	public Page<Libro> findAll(Pageable pageable,String keyword);

	public List<Libro> findAll();
	

	
	public List<Libro> findByTitulo(String titulo) ;
	
	public List<Libro> findByGenero(String genero) ;

	public List<Libro> findByAutor(String autor) ;
}
