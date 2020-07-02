package com.example.demo.controler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	}
	// Modifique el listar para que ahora tambien haga de filter
	*/
	/*
	// US busuqedad
	@GetMapping("/")
	public String listar(Model model, @Param("keyword") String keyword ) {
		List<Libro>libros=service.listarTodos(keyword);
		model.addAttribute("libros", libros);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	*/
	
	// Codigo Us Paginacion
	@GetMapping("/")
	public String listar(@RequestParam Map<String, Object> params,Model model, @Param("keyword") String keyword ) {
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 5);
		
		Page<Libro> pageLibro = service.listarTodos(pageRequest, keyword);
		
		int totalPage = pageLibro.getTotalPages();
		if(totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList()) ;
			model.addAttribute("pages", pages);
		}
		
		model.addAttribute("libros", pageLibro.getContent());
		model.addAttribute("keyword", keyword);
		return "index";
	}		
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("libro", new Libro());
		return "formLibro";
	}
	
	@PostMapping("/save")
	public String guardar(@RequestParam(name = "file",required = false) MultipartFile foto,Libro libro) {
		if (!foto.isEmpty()) {
			String ruta = "C://Temp//uploads";
			
			try {
				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				libro.setFoto(foto.getOriginalFilename());
				
			}catch (Exception e) {
				
			}
			service.save(libro);
		}
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{isbn}")
	public String delete(Model model, @PathVariable int isbn) {
		service.delete(isbn);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{isbn}")
	public String editar(Model model, @PathVariable int isbn) {
		Optional<Libro> libro = service.listarPorId(isbn); 
		 model.addAttribute("libro", libro);
		return "editarLibro";
		
	}
}
