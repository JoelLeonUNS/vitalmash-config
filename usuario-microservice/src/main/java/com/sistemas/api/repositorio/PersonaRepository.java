package com.sistemas.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.api.dominio.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
