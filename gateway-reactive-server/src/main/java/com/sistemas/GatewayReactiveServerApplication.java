package com.sistemas;

import org. springframework.boot. SpringApplication;
import org. springframework.boot. autoconfigure. SpringBootApplication;
import org. springframework. cloud. client.discovery. EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayReactiveServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayReactiveServerApplication.class, args);
	}
}