package com.javatechnologies.zettelkasten.repos;

import com.javatechnologies.zettelkasten.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
