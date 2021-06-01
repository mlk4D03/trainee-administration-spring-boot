package com.trivadis.administration.trainee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoomDTO {

    private Long id;

    private int roomNumber;

    private int capacity;

    private Long habitat;
}
