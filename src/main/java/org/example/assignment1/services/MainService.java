package org.example.assignment1.services;

import java.util.ArrayList;
import java.util.List;
import org.example.assignment1.model.Action;
import org.example.assignment1.model.Comment;
import org.example.assignment1.model.Event;
import org.example.assignment1.model.Student;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  List<Event> events = new ArrayList<Event>();
  List<Action> actions = new ArrayList<Action>();
  List<Student> students = new ArrayList<Student>();
  List<Comment> comments = new ArrayList<Comment>();

  public MainService() {
    Student s1 = new Student();
    s1.setId("412002594");
    s1.setName("Khaleel Hassan");
    s1.setEmail("kgh6265@rit.edu");
    students.add(s1);

    Event e1 = new Event();
    e1.setId("E001");
    e1.setTitle("Clubs Day");
    e1.setDescription("Clubs Day with all the clubs on campus");
    e1.setCategory("SG");
    e1.setStatus("IN_PROGRESS");
    e1.setActions(new ArrayList<>());
    events.add(e1);

    Comment c1 = new Comment();
    c1.setId("C1");
    c1.setEventid("E001");
    c1.setStudentid("412002594");
    c1.setContent("We should have more clubs and free food.");
    comments.add(c1);

    Student s2 = new Student();
    s2.setId("761005899");
    s2.setName("Aditya Avinash");
    s2.setEmail("aa1234@rit.edu");
    students.add(s2);

    Student s3 = new Student();
    s3.setId("400003132");
    s3.setName("Harsh Bhatia");
    s3.setEmail("hb5678@rit.edu");
    students.add(s3);

    Event e2 = new Event();
    e2.setId("E002");
    e2.setTitle("Hackathon");
    e2.setDescription("24 hour coding competition");
    e2.setCategory("Academic");
    e2.setStatus("PENDING");
    e2.setActions(new ArrayList<>());
    events.add(e2);

    Comment c2 = new Comment();
    c2.setId("C2");
    c2.setEventid("E002");
    c2.setStudentid("761005899");
    c2.setContent("Looking forward to this!!!");
    comments.add(c2);
  }

  public List<Event> findAllEvents() {
    return this.events;
  }

  public void addEvent(Event event) {
    this.events.add(event);
  }

  public List<Student> findAllStudents() {
    return this.students;
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public void addActionToEvent(String eventId, Action action) {
    for (Event event : events) {
      if (event.getId().equals(eventId)) {
        event.getActions().add(action);
        this.actions.add(action);
      }
    }
  }

  public List<Comment> findAllComments() {
    return comments;
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
  }
}
