package com.trivadis.administration.trainee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Year {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 4, unique = true)
    private String year;
}
