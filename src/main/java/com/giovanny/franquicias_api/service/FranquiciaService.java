package com.giovanny.franquicias_api.service;

import org.springframework.stereotype.Service;

import com.giovanny.franquicias_api.model.Franquicia;
import com.giovanny.franquicias_api.repository.FranquiciaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FranquiciaService {
    private final FranquiciaRepository repository;

    public FranquiciaService(FranquiciaRepository repository) {
        this.repository = repository;
    }

    public Flux<Franquicia> getAll() {
        return repository.findAll();
    }

    public Mono<Franquicia> save(Franquicia franquicia) {
        return repository.save(franquicia);
    }
}
