package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.ILibroService;
import com.example.demo.interfaces.ILibro;
import com.example.demo.modelo.Libro;

@Service
public class LibroService implements ILibroService{

	@Autowired
	private ILibro data;
	/*
	@Override
	public List<Libro> listarTodos() {
		return (List<Libro>)data.findAll();
	}
	*/
	// modifique el codigo para la us de bsuquedad
	// Proposito: si no recibe una keyword, muestra todos los libros existentes.
	// si recibe una keyword, muestra los libros que cumplan con la keyword
	@Override
	public List<Libro> listarTodos(String keyword) {
		if (keyword != null) {
			return data.findAll(keyword);
		}
		return (List<Libro>)data.findAll();
	}
	
	
	@Override
	public Optional<Libro> listarPorId(int id) {
		Optional<Libro> libro = data.findById(id) ;
		if ( libro.isPresent() ) {
			return libro ;
		}
		return null ;
	}

	@Override
	public int save(Libro libro) {
		int res= 0;
		Libro l= data.save(libro);
		if(!l.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int isbn) {
		data.deleteById(isbn);
	}

	
	
}
