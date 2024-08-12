package com.sistemas.api.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pedidos_detalle")
@Data

public class PedidoDetalle {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoDetalleID;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "pedidoID")
    private Pedido pedido;

    @Column(name = "producto_id")
    private Long productoID; // ID de producto obtenido de otro microservicio

    @Column(nullable = false)
    private Integer cantidad;
}

