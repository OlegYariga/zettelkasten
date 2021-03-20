package com.javatechnologies.zettelkasten;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component()
public interface NoteRepository extends CrudRepository<Note, Long> {}
