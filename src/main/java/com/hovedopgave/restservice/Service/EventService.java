package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public List<Events> findAll(){
        return eventRepository.findAll();
    }

    public Events findOne(long id){
        return eventRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException(id));
    }
}
