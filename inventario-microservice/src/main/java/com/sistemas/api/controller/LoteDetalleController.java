package com.sistemas.api.controller;

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

import com.sistemas.api.dominio.*;
import com.sistemas.api.service.*;

@RestController
@RequestMapping(value = "/api/lote", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoteDetalleController {
	@Autowired
	private LoteDetalleService loteDetalleService;
	
	@GetMapping
    public ResponseEntity<List<LoteDetalle>> getAllLoteDetalles() {
        return ResponseEntity.ok(loteDetalleService.listarTodos());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<LoteDetalle> getLoteDetalleById(@PathVariable Long id) {
		return loteDetalleService.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public ResponseEntity<LoteDetalle> createLoteDetalle(@RequestBody LoteDetalle loteDetalle) {
        return ResponseEntity.ok(loteDetalleService.agregar(loteDetalle));
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoteDetalle(@PathVariable Long id) {
		return loteDetalleService.buscar(id).map(producto -> {
			loteDetalleService.eliminar(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
    }
}