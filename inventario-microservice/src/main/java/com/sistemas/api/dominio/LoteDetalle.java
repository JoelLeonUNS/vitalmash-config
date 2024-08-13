package com.sistemas.api.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "loteDetalle")
@Data

public class LoteDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loteDetalleID;
	
	@ManyToOne
	@JoinColumn(name = "lote_id", referencedColumnName = "loteID")
	private Lote lote;
	
	@Column(name = "producto_id")
	private Long producto;  ///Id de producto obtenido de otro microservicio
	
	@Column(nullable = false)
	private Integer cantidad;
}
