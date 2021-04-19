package com.javatechnologies.zettelkasten.repos;

import com.javatechnologies.zettelkasten.domain.Note;
import com.javatechnologies.zettelkasten.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByTag(String tag);
    Note findById(Integer id);
    List<Note> findByAuthorAndTag(User user, String tag);
    List<Note> findByAuthor(User user);
}