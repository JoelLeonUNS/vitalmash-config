package com.sistemas.api.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.PedidoDetalle;
import com.sistemas.api.repositorio.PedidoDetalleRepository;
import com.sistemas.api.servicio.PedidoDetalleService;

@Service
public class PedidoDetalleServiceImpl implements PedidoDetalleService{

	@Autowired
	private PedidoDetalleRepository pedidoDetalleRepository;
	
	@Override
	public PedidoDetalle agregar(PedidoDetalle entidad) {
		return pedidoDetalleRepository.save(entidad);
	}

	@Override
	public List<PedidoDetalle> listarTodos() {
		return pedidoDetalleRepository.findAll();
	}

	@Override
	public Optional<PedidoDetalle> buscar(Long id) {
		return pedidoDetalleRepository.findById(id);
	}

	@Override
	public PedidoDetalle actualizar(PedidoDetalle entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		if (pedidoDetalleRepository.existsById(id)) {
			pedidoDetalleRepository.deleteById(id);
		}
	}

}
