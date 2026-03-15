package org.example.assignment1.controllers;

import org.example.assignment1.model.Event;
import org.example.assignment1.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    private MainService mainService;

    public EventController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/events")
    public String getEvents(Model model) {
        model.addAttribute("eventList", mainService.findAllEvents());
        return "events";
    }

    @GetMapping("/events/add")
    public String getAddEventForm() {
        return "events-add";
    }

    @PostMapping("/events/add")
    public String addEvent(Event event, Model model) {
        event.setActions(new java.util.ArrayList<>());
        mainService.addEvent(event);
        model.addAttribute("entityName", "Event");
        return "redirect:/add/success/Event";
    }

    @GetMapping("/add/success/{entityName}")
    public String getSuccessPage(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }
}
