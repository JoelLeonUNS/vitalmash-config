package com.sistemas.api.servicio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.Pedido;
import com.sistemas.api.dominio.PedidoDetalle;
import com.sistemas.api.dominio.TipoPago;
import com.sistemas.api.repositorio.PedidoDetalleRepository;
import com.sistemas.api.repositorio.PedidoRepository;
import com.sistemas.api.repositorio.TipoPagoRepository;
import com.sistemas.api.servicio.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private TipoPagoRepository tipoPagoRepository;
	@Autowired
	private PedidoDetalleRepository pedidoDetalleRepository;
	
	@Override
	public Pedido agregar(Pedido entidad) {
		/*TipoPago guardarTipoPago = tipoPagoRepository.save(entidad.getTipoPago());
		entidad.setTipoPago(guardarTipoPago);*/
		if (entidad.getTipoPago() != null && entidad.getTipoPago().getTipoPagoID() != null) {
			TipoPago tipoPagoExistente = tipoPagoRepository.findById(entidad.getTipoPago().getTipoPagoID())
					.orElseThrow(() -> new IllegalArgumentException("Tipo pago no encontrado con id " + entidad.getTipoPago().getTipoPagoID()));
			entidad.setTipoPago(tipoPagoExistente);
		} else {
			TipoPago guardarTipoPago = tipoPagoRepository.save(entidad.getTipoPago());
			entidad.setTipoPago(guardarTipoPago);
		}
		
		// Inicializa pedidoDetalles si es null
		if (entidad.getDetalles() == null) {
			entidad.setDetalles(new ArrayList<>());
		}
		
		Pedido guardarPedido = pedidoRepository.save(entidad);
		
		for (PedidoDetalle detalle : entidad.getDetalles()) {
			detalle.setPedido(guardarPedido);
			pedidoDetalleRepository.save(detalle);
		}
		
		return guardarPedido;
	}

	@Override
	public List<Pedido> listarTodos() {
		return pedidoRepository.findAll();
	}

	@Override
	public Optional<Pedido> buscar(Long id) {
		return pedidoRepository.findById(id);
	}

	@Override
	public Pedido actualizar(Pedido entidad) {
		return pedidoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		pedidoRepository.deleteById(id);
		
	}

}
