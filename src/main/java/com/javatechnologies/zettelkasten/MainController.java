package com.javatechnologies.zettelkasten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NoteRepository noteRepo;

    @GetMapping("/")
    public String mainPaige(Map<String, Object> model) {
        Iterable<Note> notes = noteRepo.findAll();

        model.put("notes", notes);
        return "mainPage";
    }

    @PostMapping
    public String addNote(
            @RequestParam String title,
            @RequestParam(required=false) String text,
            @RequestParam(defaultValue="note") String tag,
            Map<String, Object> model
    ) {
        Note note = new Note(title, text, tag);
        noteRepo.save(note);

        Iterable<Note> notes = noteRepo.findAll();
        model.put("notes", notes);

        return "mainPage";
    }
}