package com.sistemas.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.dominio.Categoria;
import com.sistemas.dominio.Etiqueta;
import com.sistemas.dominio.Presentacion;
import com.sistemas.dominio.Producto;
import com.sistemas.repositorio.CategoriaRepository;
import com.sistemas.repositorio.EtiquetaRepository;
import com.sistemas.repositorio.PresentacionRepository;
import com.sistemas.repositorio.ProductoRepository;
import com.sistemas.servicio.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
    private PresentacionRepository presentacionRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private EtiquetaRepository etiquetaRepository;

	@Override
	public Producto agregar(Producto producto) {
		if (producto.getPresentacion() != null) {
            Presentacion presentacion = presentacionRepository.findById(producto.getPresentacion().getId()).orElse(null);
            producto.setPresentacion(presentacion);
        }

        if (producto.getCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId()).orElse(null);
            producto.setCategoria(categoria);
        }

        if (producto.getEtiqueta() != null) {
            Etiqueta etiqueta = etiquetaRepository.findById(producto.getEtiqueta().getId()).orElse(null);
            producto.setEtiqueta(etiqueta);
        }
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> listarTodos() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> buscar(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public Producto actualizar(Producto entidad) {
		return productoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
		
	}
}
