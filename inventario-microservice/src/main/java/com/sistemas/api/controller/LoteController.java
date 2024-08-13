package com.sistemas.api.controller;

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

import com.sistemas.api.dominio.*;
import com.sistemas.api.service.*;

@RestController
@RequestMapping(value = "/api/lote", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoteController {
	@Autowired
	private LoteService loteService;
	
	@GetMapping
	public List<Lote> getAllLote(){
		return loteService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lote> getLoteById(@PathVariable Long id){
		return loteService.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Lote createLote(@RequestBody Lote lote) {
		return loteService.agregar(lote);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> updateLote(@PathVariable Long id, @RequestBody Lote updatedLote) {
		Lote lote = loteService.actualizar(updatedLote);
        if (lote != null) {
            return ResponseEntity.ok(lote);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLote(@PathVariable Long id) {
    	return loteService.buscar(id).map(producto -> {
			loteService.eliminar(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
    }
}
