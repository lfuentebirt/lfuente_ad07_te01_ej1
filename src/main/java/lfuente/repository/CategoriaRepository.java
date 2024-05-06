package lfuente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lfuente.domain.Categoria;

//repositorio JPA para la categoria, es un interfaz para utilizar los métodos que proporciona
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}