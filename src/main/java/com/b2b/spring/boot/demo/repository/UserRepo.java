package com.b2b.spring.boot.demo.repository;

import com.b2b.spring.boot.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
