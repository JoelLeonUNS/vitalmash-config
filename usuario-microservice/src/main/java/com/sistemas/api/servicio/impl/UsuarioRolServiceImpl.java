package com.sistemas.api.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.UsuarioDto;
import com.sistemas.api.dominio.UsuarioRol;
import com.sistemas.api.repositorio.UsuarioRepository;
import com.sistemas.api.repositorio.UsuarioRolRepository;
import com.sistemas.api.servicio.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

	@Autowired
	private UsuarioRolRepository usuarioRolRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioRol agregar(UsuarioRol entidad) {
		return usuarioRolRepository.save(entidad);
	}

	@Override
	public List<UsuarioRol> listarTodos() {
		return usuarioRolRepository.findAll();
	}

	@Override
	public Optional<UsuarioRol> buscar(Long id) {
		return usuarioRolRepository.findById(id);
	}

	@Override
	public UsuarioRol actualizar(UsuarioRol entidad) {
		return usuarioRolRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {		
		usuarioRolRepository.deleteById(id);
	}

	@Override
	public UsuarioDto getUsuarioRolById(Long id) {
		Optional<List<UsuarioRol>> rolesUsuario = usuarioRolRepository.getUsuarioRolById(id);
		UsuarioDto usuario = new UsuarioDto();
		usuario.setNombre(usuarioRepository.findById(id).get().getPersona().getNombre());
		usuario.setApellido(usuarioRepository.findById(id).get().getPersona().getApellido());
		usuario.setUsername(usuarioRepository.findById(id).get().getUsername());
		if (rolesUsuario.isPresent()) {
		    for (UsuarioRol item : rolesUsuario.get()) {
		        usuario.añadirRol(id);
		    }
		}
		return usuario;
	}

}
