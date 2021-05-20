package com.javatechnologies.zettelkasten.controller;

import com.javatechnologies.zettelkasten.domain.Note;
import com.javatechnologies.zettelkasten.domain.User;
import com.javatechnologies.zettelkasten.repos.NoteRepository;
import com.javatechnologies.zettelkasten.repos.UserRepository;
import com.javatechnologies.zettelkasten.service.UserService;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Autowired
    private NoteRepository noteRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userSevice;

    @Test
    void userList() {
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user.setUsername("admin");
        user.setIs_admin(true);

        user2.setUsername("admin2");
        user2.setIs_admin(true);

        user3.setUsername("admin3");
        user3.setIs_admin(true);

        user4.setUsername("not_admin");

        List<User> u = userRepo.findAll();
        for (User _u: u){
            if (_u.getUsername().equals("admin")){
                assertEquals(_u.getUsername(), "admin");
            }
            if (_u.getUsername().equals("admin2")){
                assertEquals(_u.getUsername(), "admin2");
            }
            if (_u.getUsername().equals("admin3")){
                assertEquals(_u.getUsername(), "admin3");
            }
            if (_u.getUsername().equals("not_admin")){
                assertFalse(_u.getIs_admin());
            }
        }

        Note note = new Note("title", "text", "tag", 100, user);
        Note note2 = new Note("title", "text", "tag", 100, user);
        Note note3 = new Note("title", "text", "tag", 100, user);
        noteRepo.save(note);
        noteRepo.save(note2);
        noteRepo.save(note3);

        Iterable<Note> notes = noteRepo.findByAuthor(user);

        assertEquals(3, IterableUtil.sizeOf(notes));
    }

    @Test
    void userSave() {
        User user = new User();
        user.setUsername("admin");
        user.setIs_admin(true);

        userRepo.save(user);
    }

}