package com.b2b.spring.boot.demo.controller;

import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.controller.api.UserAPI;
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
    public ResponseEntity<List<User>> getAllUsers(HttpServletRequest request) {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserById(HttpServletRequest request, Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> insertUser(HttpServletRequest request, User user) {
        userService.saveUser(user);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(HttpServletRequest request, User user, Long id) {
        if(userService.getUserById(id)!=null){
            userService.updateUser(user,id);
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteUserById(HttpServletRequest request, Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
