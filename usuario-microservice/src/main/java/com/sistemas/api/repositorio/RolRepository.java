package com.sistemas.api.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.api.dominio.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	
}
