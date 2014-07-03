package com.github.kburger.playground.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.kburger.playground.domain.Item;
import com.github.kburger.playground.repository.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    
    @Autowired
    private ItemRepository repository;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Item> listItems(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<Item> searchItem(@RequestParam("q") String query, @PageableDefault Pageable pageable) {
        return repository.findByName(query, pageable);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("id") Item item) {
        return item;
    }
}
