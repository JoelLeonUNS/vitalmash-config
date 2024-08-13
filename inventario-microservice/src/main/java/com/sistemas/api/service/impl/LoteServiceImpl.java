package com.sistemas.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.*;
import com.sistemas.api.Repository.*;
import com.sistemas.api.service.*;

@Service
public class LoteServiceImpl implements LoteService{
	@Autowired
	private LoteRepository loteRepository;
	
	@Override
	public Lote agregar(Lote entidad) {
		return loteRepository.save(entidad);
	}
	
	@Override
	public List<Lote> listarTodos(){
		return loteRepository.findAll();
	}
	@Override
	public Optional<Lote> buscar(Long id) {
		return loteRepository.findById(id);
	}

	@Override
	public Lote actualizar(Lote entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		if (loteRepository.existsById(id)) {
			loteRepository.deleteById(id);
		}
	}
}
