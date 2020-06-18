package com.example.demo.interfaces;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Libro;

@Repository
public interface ILibro extends CrudRepository<Libro,Integer> {


}
