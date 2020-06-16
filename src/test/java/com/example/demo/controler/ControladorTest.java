package com.example.demo.controler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.interfaces.ILibro;
import com.example.demo.modelo.Libro;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ControladorTest {
	
	
	@Autowired
	private ILibro libroService;
	
	@Test
	public void comoAdministradorDeseoVerTodosLosLibros() {
	    // given
		Libro libro1 = new Libro(1, "libro1", "libron", 0, "librito", 0);
		Libro libro2 = new Libro(2, "libro2", "libron", 0, "librito", 0);
		Libro libro3 = new Libro(3, "libro3", "libron", 0, "librito", 0);
		  
	    // when
	    
		libroService.save(libro1);
		libroService.save(libro2);
		libroService.save(libro3);
	    
		List<Libro> listaDeLibro = (List<Libro>) libroService.findAll();
	    
	    // then
	    assertTrue( !listaDeLibro.isEmpty() );
	}

	@Test
	public void comoAdministradorDeseoAgregarUnLibro() {
	    // given
		Libro libro1 = new Libro(0, "libro1", "libron", 0, "librito", 0);
	 
	    // when
	    
		libroService.save(libro1);
	    List<Libro> listaDeLibro = (List<Libro>) libroService.findAll();
	    
	    // then
	    assertTrue( listaDeLibro.contains(libro1) );
	}
	
	
	@Test
	public void comoAdministradorDeseoBorrarUnLibroPorSuISBN() {
		//given
		Libro libroNew = new Libro(1,"libroPrueba","libroAutor",3,"librazo",4) ;
		
		//when
		Libro libroGuardado = libroService.save(libroNew) ;
		List<Libro> listaDeLibro = (List<Libro>) libroService.findAll();
		libroService.deleteById(libroGuardado.getIsbn());
		
		// then
		assertFalse(listaDeLibro.contains(libroNew)) ;
	}
}

