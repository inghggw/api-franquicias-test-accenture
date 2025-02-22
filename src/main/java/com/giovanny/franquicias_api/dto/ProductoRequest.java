package com.giovanny.franquicias_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoRequest {
	@NotBlank(message = "El nombre del producto es obligatorio")
	private String nombre;

	@NotNull(message = "La sucursal es obligatoria")
	private Long sucursalId;

	@NotNull(message = "El stock es obligatorio")
	@Min(value = 0, message = "El stock no puede ser negativo")
	private Integer stock;
}
