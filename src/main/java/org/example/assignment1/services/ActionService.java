// Stydent Name: Khaleel Hassan | Student ID: 412002594
package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.dataLayer.ActionRepository;
import org.example.assignment1.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public Action saveAction(Action action) {
        return actionRepository.save(action);
    }

    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    public Optional<Action> findById(int id) {
        return actionRepository.findById(id);
    }

    public List<Action> findByEvent(Integer eventId) {
        return actionRepository.findByEventId(eventId);
    }

    public Action fullUpdate(int id, Action actionDetails) {
        Action action = actionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Action not found"));
        action.setEventid(actionDetails.getEventid());
        action.setStudentid(actionDetails.getStudentid());
        action.setTimestamp(actionDetails.getTimestamp());
        return actionRepository.save(action);
    }

    public void delete(int id) {
        actionRepository.deleteById(id);
    }
}