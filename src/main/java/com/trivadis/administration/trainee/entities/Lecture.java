package com.trivadis.administration.trainee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lecture {

    @Id
    @GeneratedValue
    Long id;

    @Column(length = 25)
    private String name;

    private String discription;

    @ManyToOne
    private Module module;
}
