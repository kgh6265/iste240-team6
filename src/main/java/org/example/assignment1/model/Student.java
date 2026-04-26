// Aditya Avinash - 761005899
package org.example.assignment1.model;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "rit_id", length = 20, nullable = false, unique = true)
  private String ritId;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(length = 100, nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private boolean active = true;

  public Student() {}

  public Student(Long id, String ritId, String name, String email, boolean active) {
    this.id = id;
    this.ritId = ritId;
    this.name = name;
    this.email = email;
    this.active = active;
  }

  public Long getId() { return id; }

  public String getRitId() { return ritId; }
  public void setRitId(String ritId) { this.ritId = ritId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public boolean isActive() { return active; }
  public boolean getActive() { return active; }
  public void setActive(boolean active) { this.active = active; }
}