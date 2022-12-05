package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {

    @Autowired
    FeedRepository feedRepository;

}
