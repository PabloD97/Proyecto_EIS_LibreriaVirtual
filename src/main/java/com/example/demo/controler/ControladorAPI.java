package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceService.ILibroService;
import com.example.demo.modelo.Libro;

@RestController
@RequestMapping(value="/libros")
public class ControladorAPI {
	
	@Autowired
	private ILibroService service ;
	
	
	// localhost:8090/libros (GET) == LISTADO DE LIBROS
	@GetMapping
	public ResponseEntity<List<Libro>> getLibros() {
		List<Libro> libros = service.listarTodos(null) ; // agregue un null pa que no llore
		if (libros.isEmpty()) {
			return ResponseEntity.noContent().build() ;
		}
		return ResponseEntity.ok(libros);
	}
	
	// localhost:8090/libros/{id}  (GET) == DEVUELVE EL LIBRO CON ESE ID
	@RequestMapping(value="/{id}")
	public ResponseEntity<Libro> getLibroPorId(@PathVariable("id") Integer id) {
		Optional<Libro> libro = service.listarPorId(id) ;
		if(libro.isPresent()) {
			return ResponseEntity.ok(libro.get()) ;
		}else {
			return ResponseEntity.noContent().build() ;
		}
	}
	
	// localhost:8090/libros/titulo={titulo}  (GET) == DEVUELVE LOS LIBROS CON ESE TITULO
	@RequestMapping(value="/titulo={titulo}")
	public ResponseEntity<List<Libro>> getLibroPorTitulo(@PathVariable("titulo") String titulo) {
		List<Libro> librosMismoTitulo = service.listarPorTitulo(titulo) ;
		return ResponseEntity.ok(librosMismoTitulo) ;
	}
	
	
	// localhost:8090/libros/genero={genero}  (GET) == DEVUELVE LOS LIBROS CON ESE GENERO
	@RequestMapping(value="/genero={genero}")
	public ResponseEntity<List<Libro>> getLibroPorGenero(@PathVariable("genero") String genero) {
		List<Libro> librosMismoGenero = service.listarPorGenero(genero) ;
		return ResponseEntity.ok(librosMismoGenero) ;
	}
	
	
	// localhost:8090/libros/autor={autor}  (GET) == DEVUELVE LOS LIBROS DE ESE AUTOR
	@RequestMapping(value="/autor={autor}")
	public ResponseEntity<List<Libro>> getLibroPorAutor(@PathVariable("autor") String autor) {
		List<Libro> librosMismoAutor = service.listarPorAutor(autor) ;
		return ResponseEntity.ok(librosMismoAutor) ;
	}
	
	
	
	// localhost:8090/libros (POST) == SE AGREGA UN LIBRO CON LOS DATOS QUE UNO QUIERA
	@PostMapping
	public ResponseEntity<Integer> addLibro(@RequestBody Libro libro) {
		Integer nuevoLibro = service.save(libro) ;
		return ResponseEntity.ok(nuevoLibro) ;
	}
	
	
	// localhost:8090/libros/{isbn} (DELETE) == ELIMINA UN LIBRO POR SU ISBN (DEVUELVE 1 SI LO ELIMINA)
	@DeleteMapping(value="/{isbn}")
	public ResponseEntity<Void> deleteLibro(@PathVariable int isbn) {
		service.delete(isbn);
		return ResponseEntity.ok(null) ;
	}
}		
	
