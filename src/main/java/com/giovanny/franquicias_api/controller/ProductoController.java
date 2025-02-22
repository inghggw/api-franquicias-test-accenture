package com.giovanny.franquicias_api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanny.franquicias_api.dto.ProductoRequest;
import com.giovanny.franquicias_api.dto.ProductoStockResponse;
import com.giovanny.franquicias_api.dto.UpdateStockRequest;
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

	@DeleteMapping("/{sucursalId}/{productoId}")
	public Mono<ResponseEntity<Map<String, String>>> deleteProductoSucursal(
			@PathVariable Long sucursalId,
			@PathVariable Long productoId) {

		return productoService.deleteProductoSucursal(sucursalId, productoId)
				.then(Mono.fromCallable(() -> {
					Map<String, String> response = new HashMap<>();
					response.put("message", "Producto eliminado de la sucursal con éxito");
					return ResponseEntity.ok(response);
				}));
	}

	@PutMapping("/stock")
	public Mono<ResponseEntity<Map<String, String>>> updateStock(@Valid @RequestBody UpdateStockRequest request) {
		return productoService.updateStock(request.getSucursalId(), request.getProductoId(), request.getStock())
				.then(Mono.fromCallable(() -> {
					Map<String, String> response = new HashMap<>();
					response.put("message", "Stock actualizado correctamente");
					return ResponseEntity.ok(response);
				}));
	}

	@GetMapping("/stock-max/{franquiciaId}")
	public Mono<ResponseEntity<List<ProductoStockResponse>>> getMaxStockBySucursal(@PathVariable Long franquiciaId) {
		return productoService.getMaxStockBySucursal(franquiciaId)
				.collectList()
				.map(ResponseEntity::ok);
	}
}
