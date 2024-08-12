package com.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.dominio.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
