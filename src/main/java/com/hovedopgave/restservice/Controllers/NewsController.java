package com.hovedopgave.restservice.Controllers;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/news")
    List<News> all() {
        return newsRepository.findAll();
    }

    @PostMapping("/news")
    News newNews(@RequestBody News newNews){
        return newsRepository.save(newNews);
    }

    @GetMapping("/news/{id}")
    News one(@PathVariable long id){
        return newsRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException(id));
    }

    @PutMapping("/news/{id}")
    News replaceNews(@RequestBody News newNews, @PathVariable Long id) {
        return newsRepository.findById(id)
                .map(news -> {
                    news.setTitle(newNews.getTitle());
                    news.setDescription(newNews.getDescription());
                    news.setImagePath(newNews.getImagePath());
                    news.setPublishDate(newNews.getPublishDate());
                    return newsRepository.save(news);
                })
                .orElseGet(() -> {
                    newNews.setId(id);
                    return newsRepository.save(newNews);
                });
    }

    @DeleteMapping("/news/{id}")
    void deleteEmployee(@PathVariable Long id){
        newsRepository.deleteById(id);
    }
}
