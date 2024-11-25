package com.tutorials.spring_genie_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringGenieGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGenieGatewayApplication.class, args);
	}

	/*
	 * @Bean public RouteLocator myRoutes(RouteLocatorBuilder builder) { return
	 * builder.routes().build(); }
	 */

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
		         .route(p -> p
		            .path("/**")
		            .filters(f -> f.addRequestHeader("Src", "Tutorialspoint"))
		            .uri("http://localhost:8088/"))
		            .build();
	}

}
