package com.sistemas.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.*;
import com.sistemas.api.Repository.*;
import com.sistemas.api.service.*;

@Service
public class LoteDetalleServiceImpl implements LoteDetalleService{
	@Autowired
	private LoteDetalleRepository loteDetalleRepository;
	
	@Override
	public LoteDetalle agregar(LoteDetalle entidad) {
		return loteDetalleRepository.save(entidad);
	}
	
	@Override
	public List<LoteDetalle> listarTodos(){
		return loteDetalleRepository.findAll();
	}
	@Override
	public Optional<LoteDetalle> buscar(Long id) {
		return loteDetalleRepository.findById(id);
	}

	@Override
	public LoteDetalle actualizar(LoteDetalle entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		if (loteDetalleRepository.existsById(id)) {
			loteDetalleRepository.deleteById(id);
		}
	}
}