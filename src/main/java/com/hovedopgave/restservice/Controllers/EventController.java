package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/events")
    List<Events> all() {
        return eventService.findAll();
    }

    @GetMapping("/events/{id}")
    Events one(@PathVariable long id){
        return eventService.findOne(id);
    }

    @PostMapping(value="/event", consumes = "application/json")
    public ResponseEntity<Events> newEvent(@RequestBody Events newEvents){
        eventService.create(newEvents);
        return new ResponseEntity<Events>(newEvents, HttpStatus.CREATED);
    }

    @PutMapping("/event/{id}")
    Events replaceEvent(@RequestBody Events newEvent, @PathVariable Long id) {
        return eventService.updateOne(newEvent, id);
    }

    @DeleteMapping("/event/{id}")
    void deleteEvent(@PathVariable Long id){
        eventService.deleteOne(id);
    }

    @PostMapping(value="/event/{eventId}/coworker/{coWorkerId}", consumes = "application/json")
    public void signupToEvent(@PathVariable Long eventId, @PathVariable Long coWorkerId){
        eventService.createEventCoWorkerColumn(eventId, coWorkerId);
    }

    @DeleteMapping("/event/{eventId}/coworker/{coWorkerId}")
    void deleteCoworkerFromEvent(@PathVariable Long eventId, @PathVariable Long coWorkerId){
        eventService.deleteCoworkerFromEvent(eventId,coWorkerId);
    }
}
