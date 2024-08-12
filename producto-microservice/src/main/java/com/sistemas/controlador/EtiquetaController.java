package com.sistemas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.dominio.Etiqueta;
import com.sistemas.servicio.EtiquetaService;

@RestController
@RequestMapping(value = "/api/etiquetas", produces = "application/json")
public class EtiquetaController {

	@Autowired
	private EtiquetaService etiquetaService;

	@GetMapping
	public List<Etiqueta> getAllEtiquetas() {
		return etiquetaService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Etiqueta> getEtiquetaById(@PathVariable Long id) {
		return etiquetaService.buscar(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Etiqueta createEtiqueta(@RequestBody Etiqueta etiqueta) {
		return etiquetaService.agregar(etiqueta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Etiqueta> updateEtiqueta(@RequestBody Etiqueta etiquetaDetails, @PathVariable Long id){
		return etiquetaService.buscar(id)
				.map(etiqueta -> {
					etiqueta.setNombre(etiquetaDetails.getNombre());
					etiqueta.setDescripcion(etiquetaDetails.getDescripcion());
					return ResponseEntity.ok(etiquetaService.actualizar(etiqueta));
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEtiqueta(@PathVariable Long id) {
		return etiquetaService.buscar(id)
				.map(etiqueta -> {
					etiquetaService.eliminar(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
