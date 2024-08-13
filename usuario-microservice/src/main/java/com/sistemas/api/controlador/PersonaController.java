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

import com.sistemas.api.dominio.Persona;
import com.sistemas.api.servicio.PersonaService;

@RestController
@RequestMapping(value = "/api/personas", produces = "application/json")
@CrossOrigin(origins = "*")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public List<Persona> getAllPersonas(){
		return personaService.listarTodos();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
    	return personaService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.agregar(persona);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> updatePersona(@RequestBody Persona personaDetails, @PathVariable Long id){
    	return personaService.buscar(id)
                .map(persona -> {
                	persona.setNombre(personaDetails.getNombre());
                	persona.setApellido(personaDetails.getApellido());
                	persona.setDireccion(personaDetails.getDireccion());
                	persona.setTelefono(personaDetails.getTelefono());
                    return ResponseEntity.ok(personaService.actualizar(persona));
                })
                .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
    	return personaService.buscar(id)
                .map(persona -> {
                	personaService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
