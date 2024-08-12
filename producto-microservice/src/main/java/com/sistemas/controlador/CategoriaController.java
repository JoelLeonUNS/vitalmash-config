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

import com.sistemas.dominio.Categoria;
import com.sistemas.servicio.CategoriaService;


@RestController
@RequestMapping(value = "/api/categorias", produces = "application/json")
@CrossOrigin(origins = "*")
public class CategoriaController {

	@Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
    	return categoriaService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.agregar(categoria);
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<Categoria> updateEtiqueta(@RequestBody Categoria categoriaDetails, @PathVariable Long id){
    	return categoriaService.buscar(id)
                .map(categoria -> {
                    categoria.setNombre(categoriaDetails.getNombre());
                    categoria.setDescripcion(categoriaDetails.getDescripcion());
                    return ResponseEntity.ok(categoriaService.actualizar(categoria));
                })
                .orElse(ResponseEntity.notFound().build());
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
    	return categoriaService.buscar(id)
                .map(categoria -> {
                    categoriaService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
