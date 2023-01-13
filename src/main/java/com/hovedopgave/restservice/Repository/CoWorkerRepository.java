package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.CoWorkers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoWorkerRepository extends JpaRepository<CoWorkers, Long> {
}
