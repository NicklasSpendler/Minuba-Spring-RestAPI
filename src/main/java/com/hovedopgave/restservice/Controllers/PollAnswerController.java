package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.PollAnswers;
import com.hovedopgave.restservice.Models.Polls;
import com.hovedopgave.restservice.Service.PollAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PollAnswerController {
    @Autowired
    PollAnswerService pollAnswerService;

    @GetMapping("/pollAnswers")
    List<PollAnswers> all() {
        return pollAnswerService.findAll();
    }
}
