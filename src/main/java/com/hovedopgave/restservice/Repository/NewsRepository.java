package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
