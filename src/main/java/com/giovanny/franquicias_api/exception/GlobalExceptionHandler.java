package com.giovanny.franquicias_api.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Captura errores de validación
	@ExceptionHandler(WebExchangeBindException.class)
	public ResponseEntity<Map<String, Object>> handleValidationException(WebExchangeBindException ex) {
		Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (msg1, _) -> msg1));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(Map.of("message", "Validation failed", "errors", errors));
	}

	// Captura errores personalizados con ResponseStatusException
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, String>> handleResponseStatusException(ResponseStatusException ex) {
		if (ex.getReason() == null) {
			throw ex;
		}

		return ResponseEntity.status(ex.getStatusCode())
				.body(Map.of("message", ex.getReason()));
	}
}
