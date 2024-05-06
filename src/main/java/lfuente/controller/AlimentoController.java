package lfuente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import lfuente.repository.AlimentoRepository;
import lfuente.repository.CategoriaRepository;

// Controlador REST para la entidad Alimentos
@RestController
@RequestMapping ("/api/alimentos")
public class AlimentoController {
	
	// Utilizamos los Repositorios de ambas entidades, para acceder a sus métodos
	@Autowired
	AlimentoRepository alimentoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	// CRUD
		//get - listado de alimentos
	@GetMapping({"/",""})
	public List<Alimento> index() {
		return alimentoRepository.findAll();
	}
	
		//get - obtener un solo alimento
	@GetMapping("/{id}")
	public Alimento show(@PathVariable("id") Long id) {
		return alimentoRepository.findById(id).orElse(null);
	}
		//post - crear alimento
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Alimento create(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}
	//put - actualizar
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Alimento update(@RequestBody Alimento alimento, @PathVariable("id") Long id) {
		Alimento alimentoTemporal = alimentoRepository.findById(id).orElse(null);
		
		alimentoTemporal.setNombre(alimento.getNombre());
		alimentoTemporal.setOrigen(alimento.getOrigen());
		alimentoTemporal.setPrecio(alimento.getPrecio());
		alimentoTemporal.setDescripcion(alimento.getDescripcion());
		alimentoTemporal.setCategoria(alimento.getCategoria());
		
		return alimentoRepository.save(alimentoTemporal);
	}
	
	// delete - borrar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		alimentoRepository.deleteById(id);
	}
}
