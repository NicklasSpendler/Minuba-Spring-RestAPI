package com.hovedopgave.restservice.Models;

import com.hovedopgave.restservice.Models.Enums.Department;
import com.hovedopgave.restservice.Models.Enums.Role;

import javax.persistence.*;


@Entity
@Table(name ="coWorkers")
public class coWorkers {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Role role;
    private Department department;
    private String imagePath;
}
