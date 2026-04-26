// Student Name: Harsh Bhatia | Student ID: 400003132
package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.model.Event;
import org.example.assignment1.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> searchEventsByTitle(String keyword) {
        return eventRepository.searchByTitle(keyword);
    }

    public List<Event> getEventsByStatus(String status) {
        return eventRepository.findByStatus(status);
    }

    public List<Event> getEventsByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public Event saveEvent(Event event) {
        if (event.getTitle() == null || event.getTitle().isEmpty())
            throw new IllegalArgumentException("Title cannot be empty");
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        existing.setTitle(updatedEvent.getTitle());
        existing.setDescription(updatedEvent.getDescription());
        existing.setCategory(updatedEvent.getCategory());
        existing.setStatus(updatedEvent.getStatus());
        return eventRepository.save(existing);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public int updateEventStatus(Long id, String status) {
        return eventRepository.updateStatusById(id, status);
    }
}