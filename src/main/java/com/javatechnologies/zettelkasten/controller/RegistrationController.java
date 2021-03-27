package com.javatechnologies.zettelkasten.controller;

import com.javatechnologies.zettelkasten.domain.Role;
import com.javatechnologies.zettelkasten.domain.User;
import com.javatechnologies.zettelkasten.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.put("message", "User already exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);

        return "registration";
    }
}
