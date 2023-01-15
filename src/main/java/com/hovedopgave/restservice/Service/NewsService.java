package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public List<News> findAll(){
        return newsRepository.findAll();
    }

    public News create(News newNews){
        return newsRepository.save(newNews);
    }

    public News findOne(long id){
        return newsRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException(id));
    }

    public News updateOne(News newNews, Long id){
        return newsRepository.findById(id)
                .map(news -> {
                    news.setTitle(newNews.getTitle());
                    news.setDescription(newNews.getDescription());
                    news.setImagePath(newNews.getImagePath());
                    news.setPublishDate(newNews.getPublishDate());
                    news.setPinned(newNews.isPinned());
                    return newsRepository.save(news);
                })
                .orElseGet(() -> {
                    newNews.setId(id);
                    return newsRepository.save(newNews);
                });
    }

    public void deleteOne(long id){
        newsRepository.deleteById(id);
    }
}
