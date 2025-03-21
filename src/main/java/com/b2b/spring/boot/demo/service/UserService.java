package com.b2b.spring.boot.demo.service;

import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.UserRecord;

import java.util.ArrayList;
import java.util.List;
public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User saveUser(User user);
    public UserRecord updateUser(ModificaUser user);
    public void deleteUserById(Long id);
}
