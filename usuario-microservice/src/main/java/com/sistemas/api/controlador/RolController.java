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

import com.sistemas.api.dominio.Rol;
import com.sistemas.api.servicio.RolService;

@RestController
@RequestMapping(value = "/api/roles", produces = "application/json")
@CrossOrigin(origins = "*")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping
	public List<Rol> getAllRoles(){
		return rolService.listarTodos();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
    	return rolService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.agregar(rol);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Rol> updateRol(@RequestBody Rol rolDetails, @PathVariable Long id){
    	return rolService.buscar(id)
                .map(rol -> {
                    rol.setNombre(rolDetails.getNombre());
                    rol.setDescripcion(rolDetails.getDescripcion());
                    rol.setEnable(rolDetails.getEnable());
                    return ResponseEntity.ok(rolService.actualizar(rol));
                })
                .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
    	return rolService.buscar(id)
                .map(rol -> {
                	rolService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
