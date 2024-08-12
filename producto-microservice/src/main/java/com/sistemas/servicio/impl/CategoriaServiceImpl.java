package com.sistemas.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.dominio.Categoria;
import com.sistemas.repositorio.CategoriaRepository;
import com.sistemas.servicio.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
    private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria agregar(Categoria entidad) {
		return categoriaRepository.save(entidad);
	}

	@Override
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

	@Override
    public Optional<Categoria> buscar(Long id) {
		return categoriaRepository.findById(id);
    }

	@Override
    public Categoria actualizar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

	@Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
