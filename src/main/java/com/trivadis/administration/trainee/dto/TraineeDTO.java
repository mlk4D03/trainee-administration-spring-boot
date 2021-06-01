package com.trivadis.administration.trainee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TraineeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Long habitat;

    private Long course;

}
