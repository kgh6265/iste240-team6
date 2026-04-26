package org.example.assignment1.services;
import java.util.ArrayList;
import java.util.List;
import org.example.assignment1.model.Action;
import org.example.assignment1.model.Comment;
import org.example.assignment1.model.Event;
import org.springframework.stereotype.Service;
@Service
public class MainService {

  List<Event> events = new ArrayList<Event>();
  List<Action> actions = new ArrayList<Action>();
  List<Comment> comments = new ArrayList<Comment>();

  public MainService() {

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

  public List<Event> findAllEvents() { return this.events; }
  public void addEvent(Event event) { this.events.add(event); }

  public void addActionToEvent(String eventId, Action action) {
    for (Event event : events) {
      if (event.getId().equals(eventId)) {
        event.getActions().add(action);
        this.actions.add(action);
      }
    }
  }

  public List<Comment> findAllComments() { return comments; }
  public void addComment(Comment comment) { this.comments.add(comment); }
}