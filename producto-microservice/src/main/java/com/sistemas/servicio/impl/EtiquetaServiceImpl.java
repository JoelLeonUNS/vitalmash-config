package com.sistemas.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.dominio.Etiqueta;
import com.sistemas.repositorio.EtiquetaRepository;
import com.sistemas.servicio.EtiquetaService;

@Service
public class EtiquetaServiceImpl implements EtiquetaService{

	@Autowired
	private EtiquetaRepository etiquetaRepository;
	
	@Override
	public Etiqueta agregar(Etiqueta entidad) {
		return etiquetaRepository.save(entidad);
	}

	@Override
	public List<Etiqueta> listarTodos() {
		return etiquetaRepository.findAll();
	}

	@Override
	public Optional<Etiqueta> buscar(Long id) {
		return etiquetaRepository.findById(id);
	}

	@Override
	public Etiqueta actualizar(Etiqueta entidad) {
		return etiquetaRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		etiquetaRepository.deleteById(id);
	}

	
}
