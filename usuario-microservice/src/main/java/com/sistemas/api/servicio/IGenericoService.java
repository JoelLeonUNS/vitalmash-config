package com.sistemas.api.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface IGenericoService <Entidad, ID>{

	public Entidad agregar (Entidad entidad);
	public List<Entidad> listarTodos ();
	public Optional<Entidad> buscar (ID id);
	public Entidad actualizar (Entidad entidad);
	public void eliminar (ID id);
}
