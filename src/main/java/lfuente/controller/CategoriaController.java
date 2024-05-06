package lfuente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lfuente.domain.Alimento;
import lfuente.domain.Categoria;
import lfuente.repository.CategoriaRepository;

//Controlador para la entidad Categoria
//Controlador para la entidad Alimentos
@RestController
@RequestMapping ("/api/categorias")
public class CategoriaController {

	// Utilizamos los Repositorios de ambas entidades, para acceder a sus métodos
	@Autowired
	CategoriaRepository categoriaRepository;
	
	// CRUD
	//get - obtener una lista
	@GetMapping({"/",""})
	public List<Categoria> index() {
		return categoriaRepository.findAll();
	}
	
	//get -  obtener una sola categoria
	@GetMapping("/{id}")
	public Categoria show(@PathVariable("id") Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	//post -  crear categoria
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	//put - modificar categoria
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria update(@RequestBody Categoria categoria, @PathVariable("id") Long id) {
		Categoria categoriaTemporal = categoriaRepository.findById(id).orElse(null);
		
		categoriaTemporal.setNombre(categoria.getNombre());
		categoriaTemporal.setPropiedades(categoria.getPropiedades());
		
		return categoriaRepository.save(categoriaTemporal);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		categoriaRepository.deleteById(id);
	}
}
