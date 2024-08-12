package com.sistemas.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info. Info;
import io.swagger.v3.oas.models.info. License;

@Configuration
public class OpenApiConfig {

	OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Spring API Normal")
						.description("Spring API REST sample application")
						.version("v0.0.1")
						.license(new License().name("Apache 2.0").url("https://springdoc.org")));
	}
}
