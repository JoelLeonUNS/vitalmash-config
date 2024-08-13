package com.sistemas.api.dominio;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UsuarioDto {
	private String nombre;
	private String apellido;
	private String username;
	private List<Long> roles = new ArrayList<>();
	
	public void añadirRol(Long id) {
		roles.add(id);
	}
}
