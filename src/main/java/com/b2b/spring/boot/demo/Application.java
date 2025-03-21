package com.b2b.spring.boot.demo;

import com.b2b.spring.boot.demo.Client.TodosClient;
import com.b2b.spring.boot.demo.Entity.Todo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class Application {
  @Autowired
  private TodosClient todosClient;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  public void todos() {
    List<Todo> todos = todosClient.getTodos();
    todos.forEach(System.out::println);
  }
}
