package com.hovedopgave.restservice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(scope = CoWorkerMonthVote.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name ="CoWorkerMonthVote")
public class CoWorkerMonthVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "votedCoWorker_id", referencedColumnName = "id")
    private CoWorkers votedCoWorker;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pollId")
    @JsonBackReference
    private Polls polls;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "coWorkers_id", referencedColumnName = "id")
    private CoWorkers coWorkers;

    public CoWorkerMonthVote() {
    }

    public CoWorkerMonthVote(long id, CoWorkers votedCoWorker, Polls polls, CoWorkers coWorkers) {
        this.id = id;
        this.votedCoWorker = votedCoWorker;
        this.polls = polls;
        this.coWorkers = coWorkers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CoWorkers getVotedCoWorker() {
        return votedCoWorker;
    }

    public void setVotedCoWorker(CoWorkers votedCoWorker) {
        this.votedCoWorker = votedCoWorker;
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
}
