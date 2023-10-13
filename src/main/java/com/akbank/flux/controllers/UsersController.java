package com.akbank.flux.controllers;

import java.time.Duration;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akbank.flux.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// https://github.com/pgjdbc/r2dbc-postgresql
// https://spring.io/projects/spring-data-r2dbc

@RestController
@RequestMapping("/api/users")
public class UsersController {

  @GetMapping("/{id}")
  public Mono<ResponseEntity<User>> GetUserById(@PathVariable("id") int id) {

    var user = new User();
    user.setName("Ali");
    user.setAge(15);
    user.setSurname("Tan");

    var response = Mono.just(user)
        .map(ResponseEntity::ok)
        .doOnNext(data -> {
          System.out.println(data.getBody());
        }).defaultIfEmpty(
            ResponseEntity.notFound().build());

    return response;
  }

  // https://projectreactor.io/docs

  @GetMapping("")
  public Flux<User> GetUsers() {

    // var users = new ArrayList<User>();
    // users.add(new User("Ahmet", "Ali", 45));
    // users.add(new User("Mustafa", "Tan", 35));
    // users.add(new User("Canan", "Ali", 25));

    var response = Flux.just(
        new User("Ahmet", "Ali", 45),
        new User("Mustafa", "Tan", 35),
        new User("Canan", "Ali", 25));

    // map sonucu değiştirip değişen reponse döndürür.
    response = response.map(item -> {
      item.setAge(14);
      System.out.println(item);
      return item;
    });

    response.subscribe(a -> {
      // asenkton kod blogu success oldyuktan sonra yapılacak işlemler burada
      // tanımlanır.
      System.out.println(a);
    });

    return response.delayElements(Duration.ofSeconds(10));
  }

}
