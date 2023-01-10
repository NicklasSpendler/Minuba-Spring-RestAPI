package com.hovedopgave.restservice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name ="PollAnswers")
public class PollAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String pollAnswers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pollId")
    @JsonBackReference
    private Polls poll;

    public PollAnswers() {
    }

    public PollAnswers(Long id, String pollAnswers, Polls poll) {
        this.Id = id;
        this.pollAnswers = pollAnswers;
        this.poll = poll;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    @Override
    public String toString() {
        return "PollAnswers{" +
                "Id=" + Id +
                ", pollAnswers='" + pollAnswers + '\'' +
                ", poll=" + poll +
                '}';
    }
}
