package com.giovanny.franquicias_api.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.giovanny.franquicias_api.model.Franquicia;

public interface FranquiciaRepository extends ReactiveCrudRepository<Franquicia, Long> {
}
