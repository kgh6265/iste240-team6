// Stydent Name: Khaleel Hassan | Student ID: 412002594
package org.example.assignment1.controllers;

import org.example.assignment1.model.Action;
import org.example.assignment1.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping
    public ResponseEntity<Action> create(@RequestBody Action action) {
        return new ResponseEntity<>(actionService.saveAction(action), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Action> getAll() {
        return actionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getOne(@PathVariable int id) {
        return actionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Action> search(@RequestParam Long eventId) {
        return actionService.findByEvent(eventId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Action> update(@PathVariable int id, @RequestBody Action action) {
        return ResponseEntity.ok(actionService.fullUpdate(id, action));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        actionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}