package com.github.kburger.playground.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.kburger.playground.domain.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, UUID>, PagingAndSortingRepository<Item, UUID> {
    Page<Item> findByName(String name, Pageable pageable);
}
