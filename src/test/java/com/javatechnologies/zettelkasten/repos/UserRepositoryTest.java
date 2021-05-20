package com.javatechnologies.zettelkasten.repos;

import com.javatechnologies.zettelkasten.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    @Autowired
    private UserRepository userRepo;

    @Test
    void findByUsername() {
        User u = userRepo.findByUsername("admin");
        assertEquals(u.getUsername(), "admin");
    }

    @Test
    void findAll() {
        List<User> u = userRepo.findAll();
        for (User _u: u){
            if (_u.getUsername().equals("admin")){
                assertEquals(_u.getUsername(), "admin");
            }
        }
    }
}