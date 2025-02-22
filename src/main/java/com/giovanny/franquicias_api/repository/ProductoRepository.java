package com.giovanny.franquicias_api.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.giovanny.franquicias_api.model.Producto;

import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {
	Flux<Producto> findByNombre(String nombre);
}
