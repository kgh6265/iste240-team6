// Stydent Name: Khaleel Hassan | Student ID: 412002594
package org.example.assignment1.model;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "event_id", nullable = false)
  private Event event;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  @Column(nullable = false)
  private String content;

  public Comment() {}

  public Comment(String content) {
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Event getEvent() { return event; }
  public void setEvent(Event event) { this.event = event; }

  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }
}
