// Stydent Name: Khaleel Hassan | Student ID: 412002594
package org.example.assignment1.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="actions")
public class Action {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "event_id", nullable = false)
  private Event event;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  @Column(nullable = false)
  private String timestamp;

  public Action() {

  }

  public Action(String timestamp) {
    this.timestamp = timestamp;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Event getEvent() { return event; }
  public void setEvent(Event event) { this.event = event; }

  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }
}
