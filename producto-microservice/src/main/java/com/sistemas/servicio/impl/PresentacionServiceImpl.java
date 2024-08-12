package com.sistemas.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.dominio.Presentacion;
import com.sistemas.repositorio.PresentacionRepository;
import com.sistemas.servicio.PresentacionService;

@Service
public class PresentacionServiceImpl implements PresentacionService{

	@Autowired
	private PresentacionRepository presentacionRepository;
	
	@Override
	public Presentacion agregar(Presentacion entidad) {
		return presentacionRepository.save(entidad);
	}

	@Override
	public List<Presentacion> listarTodos() {
		return presentacionRepository.findAll();
	}

	@Override
	public Optional<Presentacion> buscar(Long id) {	
		return presentacionRepository.findById(id);
	}

	@Override
	public Presentacion actualizar(Presentacion entidad) {
		return presentacionRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		presentacionRepository.deleteById(id);
	}
}
