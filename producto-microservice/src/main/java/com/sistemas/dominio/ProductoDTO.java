package com.sistemas.dominio;

import lombok.Data;

@Data
public class ProductoDTO {
	private Long etiqueta_id;
    private Long presentacion_id;
    private Long categoria_id;
    private Double precio;
    private Double costo;
    private Integer stock;
}
