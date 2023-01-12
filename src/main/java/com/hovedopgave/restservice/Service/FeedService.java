package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Models.Feed;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Repository.EventRepository;
import com.hovedopgave.restservice.Repository.FeedRepository;
import com.hovedopgave.restservice.Repository.NewsRepository;
import com.hovedopgave.restservice.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeedService {
    @Autowired
    FeedRepository feedRepository;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    PollRepository pollRepository;


    public Feed getFeed () {

        Feed newFeed = new Feed();

        ArrayList<News> news = new ArrayList<News>();

        newFeed.news = newsRepository.findTop2ByOrderByPublishDateDesc();



        return newFeed;
    }
}
