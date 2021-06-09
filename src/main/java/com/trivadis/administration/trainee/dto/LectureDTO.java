package com.trivadis.administration.trainee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LectureDTO {

    private Long id;

    private String name;

    private String discription;

    private Long module;

    private Long tutor;
}
