package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EventRepository extends JpaRepository<Events, Long> {

    @Modifying
    @Query(value = "INSERT INTO event_coworkers VALUES (:coworker_id, :event_id)", nativeQuery = true)
    int InsertEventCoWorkerColumn(@Param(value = "coworker_id") long coworker_id, @Param(value = "event_id") long event_id);

    @Modifying
    @Query(value = "DELETE FROM event_coworkers WHERE coworker_id = :coworker_id and event_id = :event_id", nativeQuery = true)
    int deleteCoworkerFromEventColumn(@Param(value = "coworker_id") long coworker_id, @Param(value = "event_id") long event_id);

}
