package com.hovedopgave.restservice.Repository;

import com.hovedopgave.restservice.Models.PollVotes;
import com.hovedopgave.restservice.Models.Polls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PollRepository extends JpaRepository<Polls, Long> {
    @Modifying
    @Query(value = "UPDATE poll p SET p.title = :title, p.description = :description, p.date_end = :date_end, p.date_start = :date_start, p.type = :type, p.image_path = :image_path WHERE p.poll_id = :poll_id", nativeQuery = true)
    int updatePoll(@Param(value = "poll_id") long id, @Param(value = "title") String title, @Param(value = "description") String description, @Param(value = "date_end") String date_end, @Param(value = "date_start") String date_start, @Param(value = "type") String type, @Param(value = "image_path") String image_path);

    @Modifying
    @Query(value = "INSERT INTO poll_votes (poll_answers_id, poll_id, co_workers_id) VALUES (:poll_answers_id,:poll_id,:co_workers_id)",
            nativeQuery = true)
    int savePollVote(@Param(value = "poll_answers_id") long poll_answers_id, @Param(value = "poll_id") long poll_id,
                     @Param(value = "co_workers_id") long co_workers_id);

    @Modifying
    @Query(value = "INSERT INTO co_worker_month_vote (co_workers_id, poll_id, voted_co_worker_id) VALUES (:co_workers_id,:poll_id,:voted_co_worker_id)",
            nativeQuery = true)
    int saveCoWorkerMonthVote(@Param(value = "co_workers_id") long co_workers_id, @Param(value = "poll_id") long poll_id,
                              @Param(value = "voted_co_worker_id") long voted_co_worker_id);

    @Modifying
    @Query(value = "DELETE FROM poll_votes WHERE co_workers_id = :co_workers_id and poll_id = :poll_id", nativeQuery = true)
    int deleteVote(@Param(value = "co_workers_id") long co_workers_id, @Param(value = "poll_id") long poll_id);

    @Query(value = "SELECT poll_answers.poll_answers AS answer, COUNT(*) AS count FROM poll_votes JOIN poll_answers ON poll_votes.poll_answers_id = poll_answers.id WHERE poll_votes.poll_id = :poll_id GROUP BY poll_answers.poll_answers", nativeQuery = true)
    List<Object[]> getPollResult(@Param(value = "poll_id") long poll_id);
}
