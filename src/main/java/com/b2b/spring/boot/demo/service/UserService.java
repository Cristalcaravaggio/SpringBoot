package com.b2b.spring.boot.demo.service;

import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.NuovoUser;
import com.b2b.spring.boot.demo.dto.UserRecord;
import java.util.List;
public interface UserService {

    List<UserRecord> getAllUsers ();

    void insertUser (NuovoUser oUser);

    void updateUser (ModificaUser oUser);

    void  deleteById (Long id);
}
