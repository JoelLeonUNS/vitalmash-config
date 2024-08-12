package com.sistemas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@GetMapping("/pedidoFallback")
	public String pedidoMicroserviceFallBackMethod() {
		return "Servicio de pedidos esta ocupado momentaneamente";
	}
	
	@GetMapping("/productoFallback")
	public String productoMicroserviceFallBackMethod() {
		return "Servicio de productos esta ocupado momentaneamente";
	}
	
	@GetMapping("/usuarioFallback")
	public String usuarioMicroserviceFallBackMethod() {
		return "Servicio de usuarios esta ocupado momentaneamente";
	}
	
	@GetMapping("/loteFallback")
	public String loteMicroserviceFallBackMethod() {
		return "Servicio de lotes esta ocupado momentaneamente";
	}
}
