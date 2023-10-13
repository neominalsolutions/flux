package com.akbank.flux.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.akbank.flux.models.User;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

  // functionla geliştirme şekli
  public Mono<ServerResponse> GetUsers(ServerRequest request) {

    var user = new User();
    user.setName("Ali");
    user.setAge(15);
    user.setSurname("Tan");

    var data = Mono.just(user);

    return ServerResponse.ok().body(data, User.class);

  }

}
