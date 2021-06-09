package com.trivadis.administration.trainee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {

    private Long id;

    private LocalDate start;

    private LocalDate end;

    private Long lecture;

    private Long room;

}
