package com.javatechnologies.zettelkasten.repos;

import com.javatechnologies.zettelkasten.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByTag(String tag);
    Note findById(Integer id);
}