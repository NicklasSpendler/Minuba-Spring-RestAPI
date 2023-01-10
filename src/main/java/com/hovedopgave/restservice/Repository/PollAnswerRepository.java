package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.PollAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollAnswerRepository extends JpaRepository<PollAnswers, Long> {
}
