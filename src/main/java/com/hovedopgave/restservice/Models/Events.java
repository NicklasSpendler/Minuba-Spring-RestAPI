package com.hovedopgave.restservice.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Events")
public class Events {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String imagePath;
    private String publishDate;
    private String startTime;
    private String endTime;
    private String location;
    private boolean pinned;

    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private Set<CoWorkers> coWorkers;


    public Events() {
    }

    public Events(long id, String title, String description, String imagePath, String publishDate, String startTime, String endTime, String location, boolean pinned, Set<CoWorkers> coWorkers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.publishDate = publishDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.pinned = pinned;
        this.coWorkers = coWorkers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public Set<CoWorkers> getCoWorkers() {
        return coWorkers;
    }

    public void setCoWorkers(Set<CoWorkers> coWorkers) {
        this.coWorkers = coWorkers;
    }


}
