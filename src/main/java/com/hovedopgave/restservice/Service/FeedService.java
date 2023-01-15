package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Models.Events;
import com.hovedopgave.restservice.Models.Feed;
import com.hovedopgave.restservice.Models.News;
import com.hovedopgave.restservice.Models.Polls;
import com.hovedopgave.restservice.Repository.EventRepository;
import com.hovedopgave.restservice.Repository.FeedRepository;
import com.hovedopgave.restservice.Repository.NewsRepository;
import com.hovedopgave.restservice.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

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

        HashSet<News> news = new HashSet<>();

        HashSet<Polls> polls = new HashSet<>();

        HashSet<Events> events = new HashSet<>();

        newFeed.news = newsRepository.findTop5ByOrderByPublishDateDesc();

        newFeed.polls = pollRepository.findTop5ByOrderByPublishDateDesc();

        newFeed.events = eventRepository.findTop5ByOrderByPublishDateDesc();




        return newFeed;
    }
}
