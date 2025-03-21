package com.b2b.spring.boot.demo.Client;

import com.b2b.spring.boot.demo.Entity.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "todos")
public interface TodosClient {

    @GetMapping("/todos")
    List<Todo> getTodos();
}
