package com.sistemas.controlador;

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

import com.sistemas.dominio.Presentacion;
import com.sistemas.servicio.PresentacionService;

@RestController
@RequestMapping(value = "/api/presentaciones", produces = "application/json")
@CrossOrigin(origins = "*")
public class PresentacionController {

	@Autowired
    private PresentacionService presentacionService;

    @GetMapping
    public List<Presentacion> getAllPresentaciones() {
        return presentacionService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Presentacion> getPresentacionById(@PathVariable Long id) {
    	return presentacionService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Presentacion createPresentacion(@RequestBody Presentacion presentacion) {
        return presentacionService.agregar(presentacion);
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<Presentacion> updateEtiqueta(@RequestBody Presentacion presentacionDetails, @PathVariable Long id){
    	return presentacionService.buscar(id)
				.map(presentacion -> {
					presentacion.setDescripcion(presentacionDetails.getDescripcion());
					return ResponseEntity.ok(presentacionService.actualizar(presentacion));
				})
				.orElse(ResponseEntity.notFound().build());
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresentacion(@PathVariable Long id) {
    	return presentacionService.buscar(id)
				.map(etiqueta -> {
					presentacionService.eliminar(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
    }
}
