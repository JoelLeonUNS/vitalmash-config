package com.sistemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> gatewayMVCRouteConfig() {
		return route("PedidoRuta")
				.route(path("/pedido/**"), http())
				.filter(lb("pedido-microservice"))
				.filter(circuitBreaker(circuit -> circuit
						.setId("PedidoCircuitBreaker")
						.setFallbackUri("forward:/pedidoFallback")))
				.build()
				.and(route("ProductoRuta")
						.route(path("/producto/**"), http())
						.filter(lb("producto-microservice"))
						.filter(circuitBreaker(circuit -> circuit
								.setId("ProductoCircuitBreaker")
								.setFallbackUri("forward:/productoFallback")))
						.build())
				.and(route("UsuarioRuta")
						.route(path("/usuario/**"), http())
						.filter(lb("usuario-microservice"))
						.filter(circuitBreaker(circuit -> circuit
								.setId("UsuarioCircuitBreaker")
								.setFallbackUri("forward:/usuarioFallback")))
						.build())
				.and(route("LoteRuta")
						.route(path("/lote/**"), http())
						.filter(lb("lote-microservice"))
						.filter(circuitBreaker(circuit -> circuit
								.setId("LoteCircuitBreaker")
								.setFallbackUri("forward:/loteFallback")))
						.build());
	}
}
