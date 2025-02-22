package com.giovanny.franquicias_api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.giovanny.franquicias_api.model.Sucursal;
import com.giovanny.franquicias_api.repository.SucursalRepository;

import reactor.core.publisher.Mono;

@Service
public class SucursalService {

	private final SucursalRepository sucursalRepository;

	public SucursalService(SucursalRepository sucursalRepository) {
		this.sucursalRepository = sucursalRepository;
	}

	public Mono<Sucursal> create(Sucursal sucursal) {
		return sucursalRepository.findByNombreAndFranquiciaId(sucursal.getNombre(), sucursal.getFranquiciaId())
				.flatMap(_ -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Ya existe una sucursal con ese nombre en la franquicia")))
				.switchIfEmpty(sucursalRepository.save(sucursal))
				.cast(Sucursal.class);
	}
}
