package com.sistemas.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.api.dominio.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
