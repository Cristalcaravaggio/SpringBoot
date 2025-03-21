package com.b2b.spring.boot.demo.service.implementation;

import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.UserRecord;
import com.b2b.spring.boot.demo.mapper.UserMapper;
import com.b2b.spring.boot.demo.repository.UserRepo;
import com.b2b.spring.boot.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //QUELLO DI SPRING FRAMEWORK
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public UserRecord updateUser(ModificaUser user) {
        User oUser = userRepo.findById(user.id()).orElseThrow();
        /*
        if(user.getNome()!= null){
            oUser.setNome(user.getNome());
        }
        if(user.getEmail()!= null){
            oUser.setEmail(user.getEmail());
        }
        if (user.getDettaglio() != null){
            oUser.setDettaglio(user.getDettaglio());
        }
        */
        oUser =  userMapper.partialUpdate(oUser, user);
        oUser = userRepo.save(oUser);
        return userMapper.toRecord(oUser);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }
}
