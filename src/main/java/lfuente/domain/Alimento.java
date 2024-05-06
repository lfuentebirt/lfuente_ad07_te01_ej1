package lfuente.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Clase- Entidad Alimento. 
	// Utilizamos Lombok para organizar el código y evitar el código repetitivo (getters, setters, etc.)
	// Mapeado con la tabla alimento
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="alimentos")
public class Alimento {
	
	// atributos de la clase
		// creado con secuencia en BD, y le indicamos que se incremente en 1
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String origen;
	
	private int precio;
	
	// relación ManyToOne con Categorias. Un alimento puede pertenecer a una categoria, pero una  categoria
	// puede tener más de un alimento
	// @JsonBackReference  -->  lo añadimos para que no haya bucles infinitos entre las entidades
	@JsonBackReference 
	@ManyToOne
	@JoinColumn (name = "categoria_id")
	private Categoria categoria;
	
	//Añade propiedad teamName a JSON 
	@JsonProperty("nombreCategoria")
	public String getTeamName() {
	    return categoria != null ? categoria.getNombre() : null;
	}
	
	// constructor con parámetros, pero sin la categoria
	public Alimento(String nombre, String descripcion, String origen, int precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.origen = origen;
		this.precio= precio;
	}

}
