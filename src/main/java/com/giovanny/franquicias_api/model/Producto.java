package com.giovanny.franquicias_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("productos")
public class Producto {

    @Id
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;
}
