package com.b2b.spring.boot.demo.controller.api;

import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.NuovoUser;
import com.b2b.spring.boot.demo.dto.UserRecord;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
public interface UserAPI {

    @GetMapping(produces="application/json")
    ResponseEntity<List<UserRecord>> getAllUsers(HttpServletRequest request);

    @PostMapping(produces="application/json", consumes ="application/json")
    public ResponseEntity<?> insertUser (HttpServletRequest request, @RequestBody NuovoUser oUser);

    @PutMapping(path="", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> updateUser (HttpServletRequest request, @RequestBody ModificaUser oUser);

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteUserById (HttpServletRequest request, @PathVariable Long id);
}
