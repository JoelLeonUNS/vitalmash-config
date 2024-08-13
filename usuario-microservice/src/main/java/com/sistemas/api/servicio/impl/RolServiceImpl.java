package com.sistemas.api.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.Rol;
import com.sistemas.api.repositorio.RolRepository;
import com.sistemas.api.servicio.RolService;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Rol agregar(Rol entidad) {
		return rolRepository.save(entidad);
	}

	@Override
	public List<Rol> listarTodos() {
		return rolRepository.findAll();
	}

	@Override
	public Optional<Rol> buscar(Long id) {
		return rolRepository.findById(id);
	}

	@Override
	public Rol actualizar(Rol entidad) {
		return rolRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {		
		rolRepository.deleteById(id);
	}

}
