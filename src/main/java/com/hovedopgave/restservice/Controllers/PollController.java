package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.CoWorkerMonthVote;
import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.PollVotes;
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

    @PutMapping("/poll/{id}")
    public void replacePoll(@RequestBody Polls newPoll, @PathVariable Long id) {
        pollService.updateOne(newPoll, id);
    }

    @DeleteMapping("/poll/{id}")
    void deletePoll(@PathVariable Long id){
        pollService.deleteOne(id);
    }

    @PostMapping(value="/pollvote", consumes = "application/json")
    public ResponseEntity<PollVotes> newPollVote(@RequestBody PollVotes newPollVotes){
        pollService.createVote(newPollVotes);
        return new ResponseEntity<PollVotes>(newPollVotes, HttpStatus.CREATED);
    }

    @PostMapping(value="/coworkermonthvote", consumes = "application/json")
    public ResponseEntity<CoWorkerMonthVote> newCoWorkerMonthVote(@RequestBody CoWorkerMonthVote newCoWorkerMonthVote){
        pollService.createCoWorkerMonthVote(newCoWorkerMonthVote);
        return new ResponseEntity<CoWorkerMonthVote>(newCoWorkerMonthVote, HttpStatus.CREATED);
    }
}
