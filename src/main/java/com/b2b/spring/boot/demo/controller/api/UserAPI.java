package com.b2b.spring.boot.demo.controller.api;

import com.b2b.spring.boot.demo.Entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
public interface UserAPI {

    @GetMapping(produces = "application/json")
    ResponseEntity<List<User>> getAllUsers(HttpServletRequest request);

    @GetMapping(path = "/{id}", produces = "application/json")
    ResponseEntity<User> getUserById(HttpServletRequest request, @PathVariable Long id);

    @PostMapping(produces = "application/json", consumes = "application/json")
    ResponseEntity<?> insertUser(HttpServletRequest request, @RequestBody User user);

    @PutMapping(path = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<?> updateUser(HttpServletRequest request, @RequestBody User user, @PathVariable Long id);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<?> deleteUserById(HttpServletRequest request, @PathVariable Long id);
}
