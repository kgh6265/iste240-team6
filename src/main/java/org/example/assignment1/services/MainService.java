package org.example.assignment1.services;

import org.example.assignment1.model.Action;
import org.example.assignment1.model.Event;
import org.example.assignment1.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    List<Event> events = new ArrayList<Event>();
    List<Action> actions = new ArrayList<Action>();
    List<Student> students = new ArrayList<Student>();

    public MainService() {
        Student s1 = new Student();
        s1.setId("412002594");
        s1.setName("Khaleel Hassan");
        s1.setEmail("kgh6265@rit.edu");
        students.add(s1);

        Event e1 = new Event();
        e1.setId("001");
        e1.setTitle("Clubs Day");
        e1.setCategory("SG");
        e1.setStatus("IN_PROGRESS");
        e1.setActions(new ArrayList<>());
        events.add(e1);
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
}
