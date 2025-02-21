package com.giovanny.franquicias_api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Table("sucursales")
public class Sucursal {

    @Id
    private Long id;

    @NotBlank(message = "El nombre de la sucursal es obligatorio")
    private String nombre;

    @NotNull(message = "La franquicia a la que pertenece la sucursal es obligatoria")
    private Long franquiciaId;

    private List<Producto> productos;
}
