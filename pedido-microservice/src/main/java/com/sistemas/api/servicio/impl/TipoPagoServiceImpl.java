package com.sistemas.api.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.TipoPago;
import com.sistemas.api.repositorio.TipoPagoRepository;
import com.sistemas.api.servicio.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {

	@Autowired
	private TipoPagoRepository tipoPagoRepository;
	
	@Override
	public TipoPago agregar(TipoPago entidad) {
		return tipoPagoRepository.save(entidad);
	}

	@Override
	public List<TipoPago> listarTodos() {
		return tipoPagoRepository.findAll();
	}

	@Override
	public Optional<TipoPago> buscar(Long id) {
		return tipoPagoRepository.findById(id);
	}

	@Override
	public TipoPago actualizar(TipoPago entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		if (tipoPagoRepository.existsById(id)) {
			tipoPagoRepository.deleteById(id);
		}
		
	}

}
