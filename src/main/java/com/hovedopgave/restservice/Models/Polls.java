package com.hovedopgave.restservice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Poll")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pollId")
public class Polls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollId;
    private String title;
    private String imagePath;
    private String description;
    private String type;
    private String dateStart;
    private String dateEnd;

    private boolean pinned;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pollId")
    private Set<PollAnswers> pollAnswers = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pollId")
    private Set<PollVotes> pollVotes = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pollId")
    private Set<CoWorkerMonthVote> coWorkerMonthVote = new HashSet<>();


    public Polls() {
    }

    public Polls(Long pollId, String title, String imagePath, String description, String type, String dateStart, String dateEnd, boolean pinned, Set<PollAnswers> pollAnswers, Set<PollVotes> pollVotes, Set<CoWorkerMonthVote> coWorkerMonthVote) {
        this.pollId = pollId;
        this.title = title;
        this.imagePath = imagePath;
        this.description = description;
        this.type = type;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.pinned = pinned;
        this.pollAnswers = pollAnswers;
        this.pollVotes = pollVotes;
        this.coWorkerMonthVote = coWorkerMonthVote;
    }

    public Set<PollVotes> getPollVotes() {
        return pollVotes;
    }

    public void setPollVotes(Set<PollVotes> pollVotes) {
        this.pollVotes = pollVotes;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Set<PollAnswers> getPollAnswers() {
        return pollAnswers;
    }

    public void setPollAnswers(Set<PollAnswers> pollAnswers) {
        this.pollAnswers = pollAnswers;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public Set<CoWorkerMonthVote> getCoWorkerMonthVote() {
        return coWorkerMonthVote;
    }

    public void setCoWorkerMonthVote(Set<CoWorkerMonthVote> coWorkerMonthVote) {
        this.coWorkerMonthVote = coWorkerMonthVote;
    }

    @Override
    public String toString() {
        return "Polls{" +
                "pollId=" + pollId +
                ", title='" + title + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", pinned=" + pinned +
                ", pollAnswers=" + pollAnswers +
                ", pollVotes=" + pollVotes +
                ", coWorkerMonthVote=" + coWorkerMonthVote +
                '}';
    }
}
