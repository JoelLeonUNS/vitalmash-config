package com.sistemas.api.repositorio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistemas.api.dominio.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

	@Query(value = "SELECT * FROM usuario_rol WHERE usuarioid = :id", nativeQuery = true)
	Optional<List<UsuarioRol>> getUsuarioRolById(Long id);
}
