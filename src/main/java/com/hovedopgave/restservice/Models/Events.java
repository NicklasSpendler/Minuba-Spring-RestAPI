package com.hovedopgave.restservice.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Events")
public class Events {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String imagePash;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String location;
}
