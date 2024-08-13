package com.sistemas.api.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.Usuario;
import com.sistemas.api.repositorio.UsuarioRepository;
import com.sistemas.api.servicio.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario agregar(Usuario entidad) {
		return usuarioRepository.save(entidad);
	}

	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> buscar(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario actualizar(Usuario entidad) {
		return usuarioRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {		
		usuarioRepository.deleteById(id);
	}

}
