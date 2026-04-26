// Student Name: Harsh Bhatia | Student ID: 400003132
package org.example.assignment1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(length = 255)
  private String description;

  @Column(length = 50)
  private String category;

  @Column(length = 50)
  private String status;

  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
  private List<Comment> comments;

  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
  private List<Action> actions;

  public Event() {}

  public Event(String title, String description, String category, String status) {
    this.title = title;
    this.description = description;
    this.category = category;
    this.status = status;
  }


  public Long getId() { return id; }
  public String getTitle() { return title; }
  public String getDescription() { return description; }
  public String getCategory() { return category; }
  public String getStatus() { return status; }

  public void setId(Long id) { this.id = id; }
  public void setTitle(String title) { this.title = title; }
  public void setDescription(String description) { this.description = description; }
  public void setCategory(String category) { this.category = category; }
  public void setStatus(String status) { this.status = status; }
}