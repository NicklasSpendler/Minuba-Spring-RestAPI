package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.Polls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PollRepository extends JpaRepository<Polls, Long> {
    @Modifying
    @Query(value = "UPDATE poll p SET p.title = :title, p.description = :description, p.date_end = :date_end, p.date_start = :date_start, p.type = :type, p.image_path = :image_path WHERE p.poll_id = :poll_id", nativeQuery = true)
    int updatePoll(@Param(value = "poll_id") long id, @Param(value = "title") String title, @Param(value = "description") String description, @Param(value = "date_end") String date_end, @Param(value = "date_start") String date_start, @Param(value = "type") String type, @Param(value = "image_path") String image_path);
}
