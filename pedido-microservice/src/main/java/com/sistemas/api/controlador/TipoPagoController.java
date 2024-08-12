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

import com.sistemas.api.dominio.TipoPago;
import com.sistemas.api.servicio.TipoPagoService;

@RestController
@RequestMapping(value = "/api/tipopagos", produces = "application/json")
@CrossOrigin(origins = "*")
public class TipoPagoController {

	 @Autowired
	 private TipoPagoService tipoPagoService;
	
	@GetMapping
    public ResponseEntity<List<TipoPago>> getAllTipoPagos() {
        return ResponseEntity.ok(tipoPagoService.listarTodos());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<TipoPago> getTipoPagoById(@PathVariable Long id) {
		return tipoPagoService.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public ResponseEntity<TipoPago> createTipoPago(@RequestBody TipoPago tipoPago) {
        return ResponseEntity.ok(tipoPagoService.agregar(tipoPago));
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable Long id) {
		return tipoPagoService.buscar(id).map(producto -> {
			tipoPagoService.eliminar(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
    }
}
