package com.trivadis.administration.trainee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TutorDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Long habitat;
}
