package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.Polls;
import com.hovedopgave.restservice.Service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PollController {
    @Autowired
    PollService pollService;

    @GetMapping("/polls")
    List<Polls> all() {
        return pollService.findAll();
    }

    @PostMapping(value="/poll", consumes = "application/json")
    public ResponseEntity<Polls> newPoll(@RequestBody Polls newPoll){
        pollService.create(newPoll);
        return new ResponseEntity<Polls>(newPoll, HttpStatus.CREATED);
    }

    @GetMapping("/poll/{id}")
    Polls one(@PathVariable long id){
        return pollService.findOne(id);
    }
}
