package com.giovanny.franquicias_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SucursalRequest {
	@NotBlank(message = "El nombre de la sucursal es obligatorio")
	private String nombre;
}
