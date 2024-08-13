package com.sistemas.api.dominio;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 20, nullable = false)
	@NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
	@Column(length = 60, nullable = false)
	@NotBlank(message = "La descripcion no puede estar en blanco")
    private String descripcion;
    private Boolean enable;

    @JsonIgnore
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private Set<UsuarioRol> usuarioRoles;


}
