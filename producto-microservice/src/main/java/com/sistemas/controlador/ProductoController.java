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
import com.sistemas.dominio.Etiqueta;
import com.sistemas.dominio.Presentacion;
import com.sistemas.dominio.Producto;
import com.sistemas.dominio.ProductoDTO;
import com.sistemas.servicio.CategoriaService;
import com.sistemas.servicio.EtiquetaService;
import com.sistemas.servicio.PresentacionService;
import com.sistemas.servicio.ProductoService;

@RestController
@RequestMapping(value = "/api/productos", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private EtiquetaService etiquetaService;

	@Autowired
	private PresentacionService presentacionService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Producto> getAllProductos() {
		return productoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
		return productoService.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Producto createProducto(@RequestBody Producto producto) {		
		return productoService.agregar(producto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProducto(@RequestBody ProductoDTO productoDTO, @PathVariable Long id) {

		return productoService.buscar(id).map(producto -> {
			// Actualizar campos simples
			producto.setPrecio(productoDTO.getPrecio());
			producto.setCosto(productoDTO.getCosto());
			producto.setStock(productoDTO.getStock());

			// Actualizar etiqueta
			Etiqueta etiqueta = etiquetaService.buscar(productoDTO.getEtiqueta_id())
					.orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
			producto.setEtiqueta(etiqueta);

			// Actualizar presentación
			Presentacion presentacion = presentacionService.buscar(productoDTO.getPresentacion_id())
					.orElseThrow(() -> new RuntimeException("Presentación no encontrada"));
			producto.setPresentacion(presentacion);

			// Actualizar categoría
			Categoria categoria = categoriaService.buscar(productoDTO.getCategoria_id())
					.orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
			producto.setCategoria(categoria);

			Producto updatedProducto = productoService.actualizar(producto);
			return ResponseEntity.ok(updatedProducto);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
		return productoService.buscar(id).map(producto -> {
			productoService.eliminar(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
