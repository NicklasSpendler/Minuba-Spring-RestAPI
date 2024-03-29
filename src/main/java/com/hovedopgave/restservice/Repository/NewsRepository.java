package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;

public interface NewsRepository extends JpaRepository<News, Long> {
    HashSet<News> findTop5ByOrderByPublishDateDesc();
}
