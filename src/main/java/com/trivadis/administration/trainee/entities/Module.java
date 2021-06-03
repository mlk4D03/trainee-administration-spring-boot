package com.trivadis.administration.trainee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Module {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int durationInWeeks;

    @OneToMany(mappedBy = "module")
    private List<Lecture> lectures;

    @ManyToOne
    private Course course;
}
