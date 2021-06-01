package com.trivadis.administration.trainee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate start;

    private LocalDate end;

    @OneToOne
    private Lecture lecture;

    @ManyToOne
    private Tutor tutor;

    @ManyToOne
    private Room room;

    @OneToMany
    private List<Trainee> trainees;
}
