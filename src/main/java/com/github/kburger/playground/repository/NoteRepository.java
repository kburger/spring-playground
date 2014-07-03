package com.github.kburger.playground.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.kburger.playground.domain.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, UUID>, PagingAndSortingRepository<Note, UUID> {
    Page<Note> findByItem(UUID item, Pageable pageable);
    
    Page<Note> findByTags(String tag, Pageable pageable);
}
