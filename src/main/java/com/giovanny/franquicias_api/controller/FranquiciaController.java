package com.giovanny.franquicias_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanny.franquicias_api.model.Franquicia;
import com.giovanny.franquicias_api.repository.FranquiciaRepository;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicia")
public class FranquiciaController {

    private final FranquiciaRepository repository;

    public FranquiciaController(FranquiciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Franquicia> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Franquicia> create(@Valid @RequestBody Franquicia franquicia) {
        return repository.save(franquicia);
    }
}
