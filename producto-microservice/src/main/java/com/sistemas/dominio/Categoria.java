package com.sistemas.dominio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "categorias")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String nombre;
	
	@Column(length = 90)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(targetEntity = Producto.class, fetch = FetchType.LAZY, mappedBy = "categoria")
	private List<Producto> producto;
}
