package com.sistemas.api.dominio;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lote")
@Data

public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loteID;
	
	@Column(length = 45, nullable = false)
	private String codigoLote;
	
	@Temporal(TemporalType.DATE)
	private Date fechaElaboracion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
}
