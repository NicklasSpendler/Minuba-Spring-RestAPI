package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.Polls;
import com.hovedopgave.restservice.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sound.midi.SysexMessage;
import java.util.List;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;

    public Polls create(Polls newPoll){
        return pollRepository.save(newPoll);
    }

    public List<Polls> findAll(){
        return pollRepository.findAll();
    }

    public Polls findOne(long id){
        return pollRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException(id));
    }

    public void updateOne(Polls newPoll, Long id){
        pollRepository.updatePoll(id, newPoll.getTitle(), newPoll.getDescription(), newPoll.getDateEnd(), newPoll.getDateStart(), newPoll.getType(), newPoll.getImagePath());
    }

    public void deleteOne(long id){
        pollRepository.deleteById(id);
    }
}
