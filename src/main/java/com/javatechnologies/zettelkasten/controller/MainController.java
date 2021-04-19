package com.javatechnologies.zettelkasten.controller;

import com.javatechnologies.zettelkasten.domain.Note;
import com.javatechnologies.zettelkasten.domain.User;
import com.javatechnologies.zettelkasten.repos.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String mainPaige(
            @AuthenticationPrincipal User user,
            Map<String, Object> model
    ){
        Iterable<Note> notes = noteRepo.findByAuthor(user);
        model.put("notes", notes);

        return "mainPage";
    }

    @PostMapping("/")
    public String filter(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue="note") String tag, Map<String, Object> model
    ){
        Iterable<Note> filtered_notes = noteRepo.findByAuthorAndTag(user, tag);
        model.put("notes", filtered_notes);

        return "mainPage";
    }

    @PostMapping("/add-note")
    public String addNote(
            @AuthenticationPrincipal User user,
            @RequestParam Integer parentId,
            @RequestParam String title,
            @RequestParam(required=false) String text,
            @RequestParam(defaultValue="note") String tag,
            Map<String, Object> model
    ){
        Note note = new Note(title, text, tag, parentId, user);
        noteRepo.save(note);

        return "redirect:/";
    }

    @GetMapping("/view-note")
    public String viewNote(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "false") Boolean delete,
            @RequestParam Integer id,
            Map<String, Object> model
    ){
        Note note = noteRepo.findById(id);

        if (note != null && delete) {
            note.setDeleted();
            noteRepo.save(note);

            return "redirect:/";
        }else if (note != null){
            model.put("note", note);

            Iterable<Note> other_notes = noteRepo.findByAuthor(user);
            model.put("other_notes", other_notes);

            return "viewNote";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping("/view-note")
    public String modifyNote(
            @RequestParam Integer id,
            @RequestParam Integer parentId,
            @RequestParam String title,
            @RequestParam(required=false) String text,
            @RequestParam(defaultValue="note") String tag,
            Map<String, Object> model
    ){
        Note note = noteRepo.findById(id);
        note.setTitle(title);
        note.setText(text);
        note.setTag(tag);
        note.setParentId(parentId);

        noteRepo.save(note);

        return "redirect:/";
    }
}