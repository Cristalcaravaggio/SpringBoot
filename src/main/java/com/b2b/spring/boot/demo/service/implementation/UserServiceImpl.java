package com.b2b.spring.boot.demo.service.implementation;

import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.NuovoUser;
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
    public List<UserRecord> getAllUsers() {
        return userRepo.findAll().stream().map(userMapper::toRecord).toList(); //oppure con lambda: user -> userMapper.toRecord(user))
    }

    @Override
    public void insertUser(NuovoUser oUser) {
        userRepo.save(userMapper.toEntity(oUser));
    }

    @Override
    public void updateUser(ModificaUser oUser) {
        userRepo.save(userMapper.partialUpdate(userRepo.findById(oUser.id()).orElseThrow(), oUser));
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
