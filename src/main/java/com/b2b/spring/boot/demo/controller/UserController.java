package com.b2b.spring.boot.demo.controller;

import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.controller.api.UserAPI;
import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.NuovoUser;
import com.b2b.spring.boot.demo.dto.UserRecord;
import com.b2b.spring.boot.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController implements UserAPI {
   private final UserService userService;

    @Override
    public ResponseEntity<List<UserRecord>> getAllUsers(HttpServletRequest request) {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> insertUser(HttpServletRequest request, NuovoUser user) {
        userService.insertUser(user);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(HttpServletRequest request, ModificaUser user) {
       userService.updateUser(user);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteUserById(HttpServletRequest request, Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
