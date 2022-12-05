package com.hovedopgave.restservice.Models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String imagePath;
    private String description;
    private Date publishDate;

    public News() {
    }

    public News(Long id, String title, String imagePath, String description, Date publishDate) {
        Id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.description = description;
        this.publishDate = publishDate;
    }
}
