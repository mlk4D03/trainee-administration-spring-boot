package com.trivadis.administration.trainee.dto;

import com.trivadis.administration.trainee.entities.Year;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CourseDTO {

    private Long id;

    private String name;

    private List<Long> modules;

    private Long year;

    private List<Long> trainees;
}
