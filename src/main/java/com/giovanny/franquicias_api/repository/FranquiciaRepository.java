package com.giovanny.franquicias_api.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.giovanny.franquicias_api.model.Franquicia;

import reactor.core.publisher.Flux;

@Repository
public interface FranquiciaRepository extends R2dbcRepository<Franquicia, Long> {
    Flux<Franquicia> findByNombreContaining(String nombre);
}
