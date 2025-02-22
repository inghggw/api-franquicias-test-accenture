package com.giovanny.franquicias_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanny.franquicias_api.dto.ProductoRequest;
import com.giovanny.franquicias_api.service.ProductoService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@PostMapping
	public Mono<ResponseEntity<Map<String, String>>> addProductoSucursal(@Valid @RequestBody ProductoRequest request) {
		return productoService.addProductoSucursal(request.getNombre(), request.getSucursalId(), request.getStock())
				.then(Mono.fromCallable(() -> {
					Map<String, String> response = new HashMap<>();
					response.put("message", "Producto registrado en la sucursal con éxito");
					return ResponseEntity.status(HttpStatus.CREATED).body(response);
				}));
	}
}
