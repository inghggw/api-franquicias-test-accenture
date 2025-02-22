package com.giovanny.franquicias_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("sucursal_productos")
public class SucursalProducto {

	@Id
	private Long id;

	@NotNull(message = "La sucursal es obligatoria")
	@Column("sucursal_id")
	private Long sucursalId;

	@Column("producto_id")
	@NotNull(message = "El producto es obligatorio")
	private Long productoId;

	@NotNull(message = "La cantidad en stock es obligatoria")
	@Min(value = 0, message = "La cantidad en stock no puede ser negativa")
	private Integer stock;
}
