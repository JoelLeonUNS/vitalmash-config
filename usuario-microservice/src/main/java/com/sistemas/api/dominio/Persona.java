package com.sistemas.api.dominio;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "persona")
@Data
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 35, nullable = false)
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String nombre;
	@Column(length = 35, nullable = false)
	@NotBlank(message = "El apellido no puede estar en blanco")
	private String apellido;
	@Column(length = 10, nullable = false)
	@NotBlank(message = "El genero no puede estar en blanco")
	private String genero;
	@Column(length = 60, nullable = false)
	private String direccion;
	@Column(length = 9, nullable = false, unique = true)
	@NotBlank(message = "El telefono no puede estar en blanco")
	@Size(min = 9, max = 9, message = "El telefono debe tener 9 caracteres")
	private String telefono;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;
	
	@JsonIgnore
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private Usuario usuario;
}
