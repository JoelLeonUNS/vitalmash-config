package com.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.dominio.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
