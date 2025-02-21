package com.giovanny.franquicias_api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table("franquicias")
public class Franquicia {

    @Id
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private List<Sucursal> sucursales;
}
