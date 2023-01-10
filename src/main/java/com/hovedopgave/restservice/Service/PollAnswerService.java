package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Models.PollAnswers;
import com.hovedopgave.restservice.Repository.PollAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PollAnswerService {
    @Autowired
    PollAnswerRepository pollAnswerRepository;

    public List<PollAnswers> findAll(){
        return pollAnswerRepository.findAll();
    }
}
