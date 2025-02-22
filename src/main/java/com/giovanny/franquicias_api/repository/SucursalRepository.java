package com.giovanny.franquicias_api.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.giovanny.franquicias_api.model.Sucursal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SucursalRepository extends ReactiveCrudRepository<Sucursal, Long> {

	Mono<Sucursal> findByNombreAndFranquiciaId(String nombre, Long franquiciaId);

	Flux<Sucursal> findByFranquiciaId(Long franquiciaId);
}
