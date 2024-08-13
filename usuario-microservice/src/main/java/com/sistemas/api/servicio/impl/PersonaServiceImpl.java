package com.sistemas.api.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.Persona;
import com.sistemas.api.repositorio.PersonaRepository;
import com.sistemas.api.servicio.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona agregar(Persona entidad) {
		return personaRepository.save(entidad);
	}

	@Override
	public List<Persona> listarTodos() {
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> buscar(Long id) {
		return personaRepository.findById(id);
	}

	@Override
	public Persona actualizar(Persona entidad) {
		return personaRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		personaRepository.deleteById(id);
	}

}
