package com.giovanny.franquicias_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanny.franquicias_api.model.Franquicia;
import com.giovanny.franquicias_api.repository.FranquiciaRepository;
import com.giovanny.franquicias_api.service.FranquiciaService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franquicia")
public class FranquiciaController {

    private final FranquiciaRepository franquiciaRepository;
    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaRepository franquiciaRepository, FranquiciaService franquiciaService) {
        this.franquiciaRepository = franquiciaRepository;
        this.franquiciaService = franquiciaService;

    }

    @GetMapping
    public Flux<Franquicia> getAll() {
        return franquiciaRepository.findAll();
    }

    @PostMapping
    public Mono<Franquicia> create(@Valid @RequestBody Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Map<String, String>>> updateFranquicia(@PathVariable Long id,
            @Valid @RequestBody Franquicia request) {
        return franquiciaService.update(id, request.getNombre())
                .then(Mono.fromCallable(() -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Franquicia actualizada correctamente");
                    return ResponseEntity.ok(response);
                }));
    }
}
