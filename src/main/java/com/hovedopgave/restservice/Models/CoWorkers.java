package com.hovedopgave.restservice.Models;

import com.fasterxml.jackson.annotation.*;
import com.hovedopgave.restservice.Models.Enums.Department;
import com.hovedopgave.restservice.Models.Enums.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name ="coWorkers")
@JsonIdentityInfo(scope = CoWorkers.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class CoWorkers {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Role role;
    private Department department;
    private String imagePath;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "event_coworkers",
    joinColumns = {
            @JoinColumn(name = "coworker_id", referencedColumnName = "id"),
    },
    inverseJoinColumns = {
            @JoinColumn(name = "event_id", referencedColumnName = "id")
    })
    @JsonBackReference
    private Set<Events> events;

    @JsonIgnore
    @OneToOne(mappedBy = "coWorkers")
    private PollVotes pollVotes;

    @JsonIgnore
    @OneToOne(mappedBy = "votedCoWorker")
    private CoWorkerMonthVote coWorkerMonthVote;


    public CoWorkers() {
    }

    public CoWorkers(Long id, String name, Role role, Department department, String imagePath, Set<Events> events, PollVotes pollVotes) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        this.imagePath = imagePath;
        this.events = events;
        this.pollVotes = pollVotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Events> getEvents() {
        return events;
    }

    public void setEvents(Set<Events> events) {
        this.events = events;
    }

    public PollVotes getPollVotes() {
        return pollVotes;
    }

    public void setPollVotes(PollVotes pollVotes) {
        this.pollVotes = pollVotes;
    }

    @Override
    public String toString() {
        return "CoWorkers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", department=" + department +
                ", imagePath='" + imagePath + '\'' +
                ", events=" + events +
                ", pollVotes=" + pollVotes +
                '}';
    }
}
