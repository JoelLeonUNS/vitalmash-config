package com.sistemas.api.dominio;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoID;

    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Column(name = "cliente_id")
    private Long clienteID;  // ID de cliente obtenido de otro microservicio

    @Column(name = "vendedor_id")
    private Long vendedorID; // ID de vendedor obtenido de otro microservicio

    @Column(nullable = false)
    private Boolean pagado;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", referencedColumnName = "tipoPagoID")
    private TipoPago tipoPago;

    @Column(nullable = false)
    private Double importeTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalle> detalles;
}