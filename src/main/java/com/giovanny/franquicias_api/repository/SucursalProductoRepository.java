package com.giovanny.franquicias_api.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.giovanny.franquicias_api.model.SucursalProducto;

public interface SucursalProductoRepository extends ReactiveCrudRepository<SucursalProducto, Long> {
}
