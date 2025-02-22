package com.giovanny.franquicias_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanny.franquicias_api.dto.SucursalRequest;
import com.giovanny.franquicias_api.model.Sucursal;
import com.giovanny.franquicias_api.service.SucursalService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

	private final SucursalService sucursalService;

	public SucursalController(SucursalService sucursalService) {
		this.sucursalService = sucursalService;
	}

	@PostMapping
	public Mono<ResponseEntity<Sucursal>> create(@Valid @RequestBody Sucursal sucursal) {
		return sucursalService.create(sucursal)
				.map(savedSucursal -> ResponseEntity.status(HttpStatus.CREATED).body(savedSucursal));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Map<String, String>>> update(@PathVariable Long id,
			@Valid @RequestBody SucursalRequest request) {
		return sucursalService.update(id, request.getNombre())
				.then(Mono.fromCallable(() -> {
					Map<String, String> response = new HashMap<>();
					response.put("message", "Sucursal actualizada correctamente");
					return ResponseEntity.ok(response);
				}));
	}
}
