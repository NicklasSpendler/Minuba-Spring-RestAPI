package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Events, Long> {
}
