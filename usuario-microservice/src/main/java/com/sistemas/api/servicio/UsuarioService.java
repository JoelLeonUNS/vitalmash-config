package com.sistemas.api.servicio;

import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.Usuario;

@Service
public interface UsuarioService extends IGenericoService<Usuario, Long> {

}
