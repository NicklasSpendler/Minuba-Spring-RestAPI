package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Models.Feed;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Service.FeedService;
import com.hovedopgave.restservice.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedController {

    @Autowired
    FeedService feedService;

    @GetMapping("/feed")
    Feed getFeed() {
        return feedService.getFeed();
    }

}
