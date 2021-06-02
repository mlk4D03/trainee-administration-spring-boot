package com.trivadis.administration.trainee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue
    Long id;

    @Column(length = 25)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Module> modules = new ArrayList<>();

    @OneToOne
    private Year year;

    @OneToMany(mappedBy = "course")
    private List<Trainee> trainees = new ArrayList<>();

}
