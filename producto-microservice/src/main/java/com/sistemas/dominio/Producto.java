package com.sistemas.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Etiqueta.class)
	@JoinColumn(name = "etiqueta_id", referencedColumnName = "id", nullable = false)
	private Etiqueta etiqueta;

	@ManyToOne(targetEntity = Presentacion.class)
	@JoinColumn(name = "presentacion_id", referencedColumnName = "id", nullable = false)
	private Presentacion presentacion;

	@ManyToOne(targetEntity = Categoria.class)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
	private Categoria categoria;

    @Column(nullable = false)
	private Double precio;
	
    @Column(nullable = false)
	private Double costo;
	
    @Column(nullable = false)
	private Integer stock;
}
