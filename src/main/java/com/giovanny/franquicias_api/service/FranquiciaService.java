package com.giovanny.franquicias_api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.giovanny.franquicias_api.repository.FranquiciaRepository;

import reactor.core.publisher.Mono;

@Service
public class FranquiciaService {
	private final FranquiciaRepository franquiciaRepository;

	public FranquiciaService(FranquiciaRepository franquiciaRepository) {
		this.franquiciaRepository = franquiciaRepository;
	}

	public Mono<Void> update(Long id, String nuevoNombre) {
		return franquiciaRepository.findById(id)
				.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Franquicia no encontrada")))
				.flatMap(franquicia -> {
					franquicia.setNombre(nuevoNombre);
					return franquiciaRepository.save(franquicia);
				})
				.then();
	}
}
