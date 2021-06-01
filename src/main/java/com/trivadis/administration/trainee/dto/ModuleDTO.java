package com.trivadis.administration.trainee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ModuleDTO {

    private Long id;

    private String name;

    private int durationInWeeks;

    private List<Long> lectures;

    private Long course;
}
