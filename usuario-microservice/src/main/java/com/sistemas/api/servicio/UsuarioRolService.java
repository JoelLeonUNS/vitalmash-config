package com.sistemas.api.servicio;


import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.UsuarioDto;
import com.sistemas.api.dominio.UsuarioRol;

@Service
public interface UsuarioRolService extends IGenericoService<UsuarioRol, Long>{

	public UsuarioDto getUsuarioRolById(Long id);
}
