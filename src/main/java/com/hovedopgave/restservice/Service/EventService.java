package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.Events;
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

    public Events create(Events newEvents){
        return eventRepository.save(newEvents);
    }

    public Events updateOne(Events newEvent, Long id){
        return eventRepository.findById(id)
                .map(news -> {
                    newEvent.setTitle(newEvent.getTitle());
                    newEvent.setDescription(newEvent.getDescription());
                    newEvent.setImagePath(newEvent.getImagePath());
                    newEvent.setLocation(newEvent.getLocation());
                    newEvent.setDate(newEvent.getDate());
                    newEvent.setStartTime(newEvent.getStartTime());
                    newEvent.setEndTime(newEvent.getEndTime());
                    return eventRepository.save(newEvent);
                })
                .orElseGet(() -> {
                    newEvent.setId(id);
                    return eventRepository.save(newEvent);
                });
    }
}
