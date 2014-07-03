package com.github.kburger.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.kburger.playground.domain.Item;
import com.github.kburger.playground.domain.Note;
import com.github.kburger.playground.repository.NoteRepository;

@RestController
public class NoteController {
    @Autowired
    private NoteRepository repository;
    
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public Page<Note> getNotes(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @RequestMapping(value = "/notes/tag/{tag}", method = RequestMethod.GET)
    public Page<Note> searchNotes(@PathVariable("tag") String tag, @PageableDefault Pageable pageable) {
        return repository.findByTags(tag, pageable);
    }
    
    @RequestMapping(value = "/items/{id}/notes", method = RequestMethod.GET)
    public Page<Note> getNotesForItem(@PathVariable("id") Item item, @PageableDefault Pageable pageable) {
        return repository.findByItem(item.getId(), pageable);
    }
    
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public Note getNote(@PathVariable("id") Note note) {
        return note;
    }
}
