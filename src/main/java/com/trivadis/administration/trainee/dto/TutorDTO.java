package com.trivadis.administration.trainee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TutorDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Long habitat;

    private List<Long> lectures;
}
