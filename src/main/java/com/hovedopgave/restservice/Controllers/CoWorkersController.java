package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.CoWorkers;
import com.hovedopgave.restservice.Service.CoWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CoWorkersController {
    @Autowired
    CoWorkerService coWorkerService;

    @GetMapping("/coworkers")
    List<CoWorkers> all() {
        return coWorkerService.findAll();
    }
}
