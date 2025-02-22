package com.giovanny.franquicias_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoStockResponse {
	private String nombreProducto;
	private Long sucursalId;
	private String nombreSucursal;
	private Integer stock;
}
