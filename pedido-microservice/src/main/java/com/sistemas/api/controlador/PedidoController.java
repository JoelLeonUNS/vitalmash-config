package com.sistemas.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.api.dominio.Pedido;
import com.sistemas.api.servicio.PedidoService;

@RestController
@RequestMapping(value = "/api/pedidos", produces = "application/json")
@CrossOrigin(origins = "*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> getAllPedidos(){
		return pedidoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id){
		return pedidoService.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Pedido createPedido(@RequestBody Pedido pedido) {
		return pedidoService.agregar(pedido);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> updatePedido(@PathVariable Long id, @RequestBody Pedido updatedPedido) {
        Pedido pedido = pedidoService.actualizar(updatedPedido);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
    	return pedidoService.buscar(id).map(producto -> {
			pedidoService.eliminar(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
    }
}
