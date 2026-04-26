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

  @Column(nullable = false)
  private Integer eventid;

  @Column(nullable = false)
  private Integer studentid;

  @Column(nullable = false)
  private String timestamp;

  public Action() {

  }

  public Action(Integer eventid, Integer studentid, String timestamp) {
    this.eventid = eventid;
    this.studentid = studentid;
    this.timestamp = timestamp;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Integer getEventid() {
    return eventid;
  }

  public void setEventid(Integer eventid) {
    this.eventid = eventid;
  }

  public Integer getStudentid() {
    return studentid;
  }

  public void setStudentid(Integer studentid) {
    this.studentid = studentid;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
