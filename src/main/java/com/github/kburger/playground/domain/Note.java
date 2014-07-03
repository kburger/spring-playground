package com.github.kburger.playground.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {
    @Id
    private UUID id;
    private String title;
    private String content;
    private List<String> tags;
    private UUID item;
    
    public UUID getId() {
        return id;
    }
    
//    public void setId(UUID id) {
//        this.id = id;
//    }
    
    public String getTitle() {
        return title;
    }
    
//    public void setTitle(String title) {
//        this.title = title;
//    }
    
    public String getContent() {
        return content;
    }
    
//    public void setContent(String content) {
//        this.content = content;
//    }
    
    public List<String> getTags() {
        return tags;
    }
    
//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }
    
    public UUID getItem() {
        return item;
    }
    
//    public void setItem(UUID item) {
//        this.item = item;
//    }
}
