package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Libro;

public interface ILibroService {
	
	public List<Libro>listarTodos(String keyword);	
	public List<Libro> listarPorTitulo(String titulo) ;
	public List<Libro> listarPorGenero(String genero) ;
	public List<Libro> listarPorAutor(String autor) ;
	public Optional<Libro>listarPorId(int id);
	public int save(Libro p);
	public void delete(int id);
	
}
