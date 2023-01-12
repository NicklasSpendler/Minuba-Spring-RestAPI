package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}