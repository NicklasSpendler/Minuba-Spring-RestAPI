package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Models.CoWorkers;
import com.hovedopgave.restservice.Repository.CoWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoWorkerService {
    @Autowired
    CoWorkerRepository coWorkerRepository;

    public List<CoWorkers> findAll(){
        return coWorkerRepository.findAll();
    }
}
