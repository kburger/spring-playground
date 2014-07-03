package com.github.kburger.playground.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {
    @Id
    private UUID id;
    private String name;
    
    public UUID getId() {
        return id;
    }
    
//    public void setId(UUID id) {
//        this.id = id;
//    }
    
    public String getName() {
        return name;
    }
    
//    public void setName(String name) {
//        this.name = name;
//    }
}
