package com.akbank.flux.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.akbank.flux.handlers.UserHandler;

@Configuration
public class RouteConfig {
  private static final String apiPrefix = "/api/func";

  @Bean
  public RouterFunction<ServerResponse> functionalRoutes(UserHandler userHandler) {
    return RouterFunctions.route(RequestPredicates.GET(apiPrefix), userHandler::GetUsers);
  }
}
