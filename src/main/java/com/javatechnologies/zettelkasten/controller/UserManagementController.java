package com.javatechnologies.zettelkasten.controller;

import com.javatechnologies.zettelkasten.domain.Note;
import com.javatechnologies.zettelkasten.domain.User;
import com.javatechnologies.zettelkasten.repos.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class UserManagementController {
    @Autowired
    private NoteRepository noteRepo;

    @GetMapping("/user-control")
    public String controlPage(
            @AuthenticationPrincipal User user,
            Map<String, Object> model
    ){
        Iterable<Note> notes = noteRepo.findByAuthor(user);
        model.put("notes", notes);

        return "controlPage";
    }
}
