package org.example.assignment1.model;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer eventid;

  @Column(nullable = false)
  private Integer studentid;

  @Column(nullable = false)
  private String content;

  public Comment() {}

  public Comment(Integer eventid, Integer studentid, String content) {
    this.eventid = eventid;
    this.studentid = studentid;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
