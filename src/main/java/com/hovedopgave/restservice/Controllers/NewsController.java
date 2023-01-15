package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Repository.NewsRepository;
import com.hovedopgave.restservice.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    List<News> all() {
        return newsService.findAll();
    }

    @PostMapping(value="/news", consumes = "application/json")
    public ResponseEntity<News> newNews(@RequestBody News newNews){
        newsService.create(newNews);
        return new ResponseEntity<News>(newNews, HttpStatus.CREATED);
    }

    @GetMapping("/news/{id}")
    News one(@PathVariable long id){
        return newsService.findOne(id);
    }

    @PutMapping("/news/{id}")
    News replaceNews(@RequestBody News newNews, @PathVariable Long id) {

        return newsService.updateOne(newNews, id);
    }

    @DeleteMapping("/news/{id}")
    void deleteNews(@PathVariable Long id){
        newsService.deleteOne(id);
    }


}
