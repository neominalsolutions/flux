package com.akbank.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.akbank.flux.routes.RouteConfig;

@EnableWebFlux
@SpringBootApplication
public class FluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxApplication.class, args);
	}

}
