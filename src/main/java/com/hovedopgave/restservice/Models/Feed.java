package com.hovedopgave.restservice.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Feed {
    @Id
    public long Id;

    @OneToMany
    public Set<News> news = new HashSet<>();

    @OneToMany
    public Set<Events> events = new HashSet<>();

    @OneToMany
    public Set<Polls> polls = new HashSet<>();

}
