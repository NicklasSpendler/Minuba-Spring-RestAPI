package com.hovedopgave.restservice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(scope = PollVotes.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name ="PollVotes")
public class PollVotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_answers_id", referencedColumnName = "id")
    private PollAnswers pollAnswers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pollId")
    @JsonBackReference
    private Polls polls;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "coWorkers_id", referencedColumnName = "id")
    private CoWorkers coWorkers;

    public PollVotes() {
    }

    public PollVotes(long id, PollAnswers pollAnswers, Polls polls, CoWorkers coWorkers) {
        this.id = id;
        this.pollAnswers = pollAnswers;
        this.polls = polls;
        this.coWorkers = coWorkers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PollAnswers getPollAnswers() {
        return pollAnswers;
    }

    public void setPollAnswers(PollAnswers pollAnswers) {
        this.pollAnswers = pollAnswers;
    }

    public Polls getPolls() {
        return polls;
    }

    public void setPolls(Polls polls) {
        this.polls = polls;
    }

    public CoWorkers getCoWorkers() {
        return coWorkers;
    }

    public void setCoWorkers(CoWorkers coWorkers) {
        this.coWorkers = coWorkers;
    }

    @Override
    public String toString() {
        return "PollVotes{" +
                "id=" + id +
                ", pollAnswers=" + pollAnswers +
                ", polls=" + polls +
                ", coWorkers=" + coWorkers +
                '}';
    }
}
