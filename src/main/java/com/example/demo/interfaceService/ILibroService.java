package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Libro;

public interface ILibroService {
	
//	public List<Libro>listarTodos();
	// modifique el listar todos, ahora recibe una keyword
	public List<Libro>listarTodos(String keyword);	
	
	public Optional<Libro>listarPorId(int id);
	public int save(Libro p);
	public void delete(int id);
}
