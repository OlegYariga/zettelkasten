package com.javatechnologies.zettelkasten.repos;

import com.javatechnologies.zettelkasten.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Override
    List<User> findAll();
}
