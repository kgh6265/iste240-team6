// Student Name: Harsh Bhatia | Student ID: 40003132
package org.example.assignment1;

import org.example.assignment1.model.Event;
import org.example.assignment1.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DataSeeder {

    @Autowired
    private EventRepository eventRepository;

    @PostConstruct
    public void seedEvents() {
        if (eventRepository.count() == 0) {
            eventRepository.save(new Event("Clubs Day", "All clubs showcase on campus", "SG", "IN_PROGRESS"));
            eventRepository.save(new Event("Hackathon", "24 hour coding competition", "Academic", "PENDING"));
            eventRepository.save(new Event("Career Fair", "Meet top employers in the region", "Academic", "PENDING"));
            eventRepository.save(new Event("Cultural Night", "Celebrate diversity at RIT Dubai", "Social", "COMPLETED"));
        }
    }
}