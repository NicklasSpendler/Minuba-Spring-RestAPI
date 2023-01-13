package com.hovedopgave.restservice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="PollAnswers")
@JsonIdentityInfo(scope = PollAnswers.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PollAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String pollAnswers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pollId")
    @JsonBackReference
    private Polls poll;

    @OneToOne(mappedBy = "pollAnswers", fetch = FetchType.LAZY)
    private PollVotes pollVotes;

    public PollAnswers() {
    }

    public PollAnswers(Long id, String pollAnswers, Polls poll, PollVotes pollVotes) {
        Id = id;
        this.pollAnswers = pollAnswers;
        this.poll = poll;
        this.pollVotes = pollVotes;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getPollAnswers() {
        return pollAnswers;
    }

    public void setPollAnswers(String pollAnswers) {
        this.pollAnswers = pollAnswers;
    }

    public Polls getPoll() {
        return poll;
    }

    public void setPoll(Polls poll) {
        this.poll = poll;
    }

    public PollVotes getPollVotes() {
        return pollVotes;
    }

    public void setPollVotes(PollVotes pollVotes) {
        this.pollVotes = pollVotes;
    }

    @Override
    public String toString() {
        return "PollAnswers{" +
                "Id=" + Id +
                ", pollAnswers='" + pollAnswers + '\'' +
                ", poll=" + poll +
                ", pollVotes=" + pollVotes +
                '}';
    }
}
