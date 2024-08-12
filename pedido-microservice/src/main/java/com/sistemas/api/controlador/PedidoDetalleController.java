package com.sistemas.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.api.dominio.PedidoDetalle;
import com.sistemas.api.servicio.PedidoDetalleService;

@RestController
@RequestMapping(value = "/api/pedidodetalles", produces = "application/json")
@CrossOrigin(origins = "*")
public class PedidoDetalleController {

	@Autowired
	private PedidoDetalleService pedidoDetalleService;
	
	@GetMapping
    public ResponseEntity<List<PedidoDetalle>> getAllPedidoDetalles() {
        return ResponseEntity.ok(pedidoDetalleService.listarTodos());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<PedidoDetalle> getPedidoDetalleById(@PathVariable Long id) {
		return pedidoDetalleService.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public ResponseEntity<PedidoDetalle> createPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle) {
        return ResponseEntity.ok(pedidoDetalleService.agregar(pedidoDetalle));
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedidoDetalle(@PathVariable Long id) {
		return pedidoDetalleService.buscar(id).map(producto -> {
			pedidoDetalleService.eliminar(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
    }
}
