package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
