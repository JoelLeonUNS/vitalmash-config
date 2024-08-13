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
import com.sistemas.api.dominio.UsuarioRol;
import com.sistemas.api.servicio.UsuarioRolService;

@RestController
@RequestMapping(value = "/api/usuarioRol", produces = "application/json")
@CrossOrigin(origins = "*")
public class UsuarioRolController {
	
	@Autowired
	private UsuarioRolService usuarioRolService;
	
	@GetMapping
	public List<UsuarioRol> getAllUsuarioRoles(){
		return usuarioRolService.listarTodos();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> getUsuariosRolesById(@PathVariable Long id) {
    	return usuarioRolService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public UsuarioRol createUsuarioRol(@RequestBody UsuarioRol usuarioRol) {
        return usuarioRolService.agregar(usuarioRol);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioRol> updateUsuarioRol(@RequestBody UsuarioRol usuarioRolDetail, @PathVariable Long id){
    	return usuarioRolService.buscar(id)
                .map(usuarioRol -> {
                	usuarioRol.setUsuario(usuarioRolDetail.getUsuario());
                	usuarioRol.setRol(usuarioRolDetail.getRol());
                	usuarioRol.setEnable(usuarioRolDetail.getEnable());
                    return ResponseEntity.ok(usuarioRolService.actualizar(usuarioRol));
                })
                .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioRol(@PathVariable Long id) {
    	return usuarioRolService.buscar(id)
                .map(usuarioRol -> {
                	usuarioRolService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
