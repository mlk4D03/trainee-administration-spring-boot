package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.ScheduleDTO;
import com.trivadis.administration.trainee.entities.Schedule;
import com.trivadis.administration.trainee.entities.Trainee;
import com.trivadis.administration.trainee.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ScheduleDTO saveSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return transformToDTO(this.scheduleService.saveSchedule(scheduleDTO));
    }

    @GetMapping("/{scheduleId}")
    public ScheduleDTO findScheduleById(@PathVariable Long scheduleId) {
        return transformToDTO(this.scheduleService.findScheduleById(scheduleId));
    }

    @GetMapping("/getAllSchedules")
    public List<ScheduleDTO> getAllScheduleItems() {
        List<Schedule> schedules = this.scheduleService.getAllSchedules();
        return schedules.stream().map(this::transformToDTO).collect(Collectors.toList());
    }

    private ScheduleDTO transformToDTO(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setStart(schedule.getStart());
        scheduleDTO.setEnd(schedule.getEnd());
        if (schedule.getRoom() != null) {
            scheduleDTO.setRoom(schedule.getRoom().getId());
        }
        if (schedule.getLecture() != null) {
            scheduleDTO.setLecture(schedule.getLecture().getId());
        }
        scheduleDTO.setId(schedule.getId());
        return scheduleDTO;
    }
}
