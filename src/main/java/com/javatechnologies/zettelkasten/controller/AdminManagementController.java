package com.javatechnologies.zettelkasten.controller;

import com.javatechnologies.zettelkasten.domain.Note;
import com.javatechnologies.zettelkasten.domain.User;
import com.javatechnologies.zettelkasten.repos.NoteRepository;
import com.javatechnologies.zettelkasten.repos.UserRepository;
import com.javatechnologies.zettelkasten.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;


@Controller
public class AdminManagementController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NoteRepository noteRepo;

    @Autowired
    private UserRepository userRepo;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/control")
    public String controlPage(
            @AuthenticationPrincipal User user,
            Map<String, Object> model
    ){
        if (user.getIs_admin()) {
            Iterable<Note> notes = noteRepo.findAll();

            // select all notes number
            Long all_notes = noteRepo.count();

            // select only deleted notes (trash)
            RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
            String sql = "SELECT Count(*) FROM note WHERE deleted=1";
            jdbcTemplate.query(sql, countCallback);
            int deleted_notes = countCallback.getRowCount();

            // select notes by author distribution
            Map<String, Long> userNotesDistribution = new HashMap<>();
            Iterable<User> users = userRepo.findAll();


            for(User u: users){
                Long user_notes_count = noteRepo.countByAuthor(u);
                userNotesDistribution.put(u.getUsername(), user_notes_count);
            }

            Set<Map.Entry<String,Long>> entrySet = userNotesDistribution.entrySet();

            model.put("notes", notes);
            model.put("all_notes", all_notes);
            model.put("deleted_notes", deleted_notes);
            model.put("entrySet", entrySet);


            return "adminControlPage";
        }
        return "redirect:/";
    }
}
