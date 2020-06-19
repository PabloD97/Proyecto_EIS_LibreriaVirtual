package com.example.demo.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.ILibroService;
import com.example.demo.modelo.Libro;



@Controller
@RequestMapping()
public class Controlador {
	
	@Autowired
	private ILibroService service;
	/*
	@GetMapping("/")
	public String listar(Model model) {
		List<Libro>libros=service.listarTodos();
		model.addAttribute("libros", libros);
		return "index";
	}*/
	// Modifique el listar para que ahora tambien haga de filter
	@GetMapping("/")
	public String listar(Model model, @Param("keyword") String keyword ) {
		List<Libro>libros=service.listarTodos(keyword);
		model.addAttribute("libros", libros);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("libro", new Libro());
		return "formLibro";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid Libro libro, Model model) {
		service.save(libro);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{isbn}")
	public String delete(Model model, @PathVariable int isbn) {
		service.delete(isbn);
		return "redirect:/";
	}
	
	
	
}
