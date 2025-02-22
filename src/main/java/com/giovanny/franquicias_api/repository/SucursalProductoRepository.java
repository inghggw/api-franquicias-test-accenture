package com.giovanny.franquicias_api.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.giovanny.franquicias_api.model.SucursalProducto;

import reactor.core.publisher.Mono;

public interface SucursalProductoRepository extends ReactiveCrudRepository<SucursalProducto, Long> {
	Mono<SucursalProducto> findBySucursalIdAndProductoId(Long sucursalId, Long productoId);
}
