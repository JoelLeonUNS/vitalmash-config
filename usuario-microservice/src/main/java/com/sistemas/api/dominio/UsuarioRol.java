package com.sistemas.api.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarioRol")
@Data
public class UsuarioRol {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "rolID")
    private Rol rol;

    private Boolean enable; 
}
