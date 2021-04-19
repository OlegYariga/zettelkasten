package com.javatechnologies.zettelkasten.controller;

import com.javatechnologies.zettelkasten.domain.Note;
import com.javatechnologies.zettelkasten.domain.User;
import com.javatechnologies.zettelkasten.repos.NoteRepository;
import com.javatechnologies.zettelkasten.repos.UserRepository;
import com.javatechnologies.zettelkasten.service.UserService;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MainControllerTest {
    @Autowired
    private NoteRepository noteRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Test
    void mainPaige() {
        User user = new User();
        user.setUsername("admin");

        Note note = new Note("title", "text", "tag", 100, user);
        noteRepo.save(note);

        Iterable<Note> notes = noteRepo.findByAuthor(user);

        assertEquals(1, IterableUtil.sizeOf(notes));
    }

    @Test
    void viewNote() {
        User user = new User();
        user.setUsername("admin");

        Note createdNote = new Note("title", "text", "tag", 100, user);
        noteRepo.save(createdNote);

        Note note = noteRepo.findById(1);
        assertEquals(note.getId(), 1);
    }

    @Test
    void modifyNote() {
        User user = new User();
        user.setUsername("admin");

        Note createdNote = new Note("title", "text", "tag", 100, user);
        noteRepo.save(createdNote);

        Note note = noteRepo.findById(1);
        note.setTitle("title2");
        note.setText("text2");
        note.setTag("tag2");
        note.setParentId(2);

        noteRepo.save(note);

        assertEquals(note.getTitle(), "title2");
    }
}