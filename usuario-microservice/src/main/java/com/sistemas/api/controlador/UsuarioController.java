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

import com.sistemas.api.dominio.Usuario;
import com.sistemas.api.dominio.UsuarioDto;
import com.sistemas.api.servicio.UsuarioRolService;
import com.sistemas.api.servicio.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuarios", produces = "application/json")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired 
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRolService usuarioRolService;
	
	@GetMapping
	public List<Usuario> getAllUsuarios(){
		return usuarioService.listarTodos();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
    	return usuarioService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping("/{id}/roles")
	public ResponseEntity<UsuarioDto> getRolesUsuario(@PathVariable Long id){
		usuarioRolService.getUsuarioRolById(id);
		return null;
	}
		
	@PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.agregar(usuario);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuarioDetails, @PathVariable Long id){
    	return usuarioService.buscar(id)
                .map(usuario -> {
                	usuario.setUsername(usuarioDetails.getUsername());
                	usuario.setPassword(usuarioDetails.getPassword());
                	usuario.setEnable(usuarioDetails.getEnable());
                    return ResponseEntity.ok(usuarioService.actualizar(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
    	return usuarioService.buscar(id)
                .map(usuario -> {
                	usuarioService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
