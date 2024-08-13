package com.sistemas.api.servicio;

import org.springframework.stereotype.Service;

import com.sistemas.api.dominio.Persona;

@Service
public interface PersonaService extends IGenericoService<Persona, Long> {

}
