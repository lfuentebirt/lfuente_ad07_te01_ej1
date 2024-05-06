package lfuente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lfuente.domain.Alimento;

// repositorio JPA para el alimento, es un interfaz para utilizar los métodos que proporciona 
public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
	
}
