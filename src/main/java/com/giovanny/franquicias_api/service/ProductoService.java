package com.giovanny.franquicias_api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.giovanny.franquicias_api.model.Producto;
import com.giovanny.franquicias_api.model.SucursalProducto;
import com.giovanny.franquicias_api.repository.ProductoRepository;
import com.giovanny.franquicias_api.repository.SucursalProductoRepository;
import com.giovanny.franquicias_api.repository.SucursalRepository;

import reactor.core.publisher.Mono;

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	private final SucursalProductoRepository sucursalProductoRepository;
	private final SucursalRepository sucursalRepository;

	public ProductoService(ProductoRepository productoRepository, SucursalProductoRepository sucursalProductoRepository,
			SucursalRepository sucursalRepository) {
		this.productoRepository = productoRepository;
		this.sucursalProductoRepository = sucursalProductoRepository;
		this.sucursalRepository = sucursalRepository;
	}

	public Mono<Void> addProductoSucursal(String nombre, Long sucursalId, Integer stock) {
		return sucursalRepository.existsById(sucursalId)
				.flatMap(exists -> {
					if (!exists) {
						return Mono.error(
								new ResponseStatusException(HttpStatus.BAD_REQUEST, "La sucursal con ID " + sucursalId + " no existe"));
					}
					return productoRepository.findByNombre(nombre)
							.next()
							.switchIfEmpty(productoRepository.save(new Producto(null, nombre)));
				})
				.flatMap(producto -> {
					return sucursalProductoRepository
							.findBySucursalIdAndProductoId(sucursalId, producto.getId())
							.flatMap(_ -> Mono.error(new ResponseStatusException(
									HttpStatus.BAD_REQUEST, "El producto ya está registrado en la sucursal")))
							.switchIfEmpty(
									sucursalProductoRepository.save(new SucursalProducto(null, sucursalId, producto.getId(), stock)));
				})
				.then();
	}

	public Mono<Void> deleteProductoSucursal(Long sucursalId, Long productoId) {
		return sucursalProductoRepository
				.findBySucursalIdAndProductoId(sucursalId, productoId)
				.switchIfEmpty(Mono.error(new ResponseStatusException(
						HttpStatus.NOT_FOUND, "El producto no existe en la sucursal")))
				.flatMap(sucursalProductoRepository::delete);
	}

	public Mono<Void> updateStock(Long sucursalId, Long productoId, Integer stock) {
		return sucursalProductoRepository.findBySucursalIdAndProductoId(sucursalId, productoId)
				.switchIfEmpty(Mono.error(new ResponseStatusException(
						HttpStatus.NOT_FOUND, "No se encontró el producto en la sucursal")))
				.flatMap(sucursalProducto -> {
					sucursalProducto.setStock(stock);
					return sucursalProductoRepository.save(sucursalProducto);
				})
				.then();
	}
}
