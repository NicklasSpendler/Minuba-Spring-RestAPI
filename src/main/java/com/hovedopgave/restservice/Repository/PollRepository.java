package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.Polls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Polls, Long> {
}
