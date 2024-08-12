package com. sistemas.controller;

import org. springframework.web.bind. annotation. GetMapping;
import org. springframework.web.bind. annotation. RestController;

@RestController
public class FallBackController {

	@GetMapping("/clienteFallback")
	public String clienteMicroserviceFallbackMethod() {
		return "Servicio de clientes esta ocupado momentaneamente";
	}
	
	@GetMapping("/empleadoFallback")
	public String empleadoMicroserviceFallbackMethod() {
		return "Servicio de empleados esta ocupado momentaneamente";
	}
	
	@GetMapping("/ordenFallback")
	public String ordenMicroserviceFallbackMethod() {
		return "Servicio de ordenes esta ocupado momentaneamente";
	}
}