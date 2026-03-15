package org.example.assignment1.model;

import org.springframework.stereotype.Component;

import java.util.List;

public class Event {

    private String id;
    private String title;
    private String description;
    private String category;
    private String status;
    private List<Action> actions;
    private List<Comment> comments;

    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Action> getActions() { return actions; }

    public void setActions(List<Action> actions) { this.actions = actions; }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
