package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelo.Libro;

public interface ILibroService {
	
	// aca se rompe con todo
	public List<Libro>listarLibros();	

	public Page<Libro>listarTodos(Pageable pageable, String keyword);	
	public List<Libro> listarPorTitulo(String titulo) ;
	public List<Libro> listarPorGenero(String genero) ;
	public List<Libro> listarPorAutor(String autor) ;
	public Optional<Libro>listarPorId(int id);
	public int save(Libro p);
	public void delete(int id);
}
