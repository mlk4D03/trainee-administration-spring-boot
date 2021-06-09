package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.ScheduleDTO;
import com.trivadis.administration.trainee.entities.*;
import com.trivadis.administration.trainee.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    private RoomRepository roomRepository;

    private LectureRepository lectureRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, RoomRepository roomRepository, LectureRepository lectureRepository) {
        this.scheduleRepository = scheduleRepository;
        this.roomRepository = roomRepository;
        this.lectureRepository = lectureRepository;
    }

    public Schedule saveSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setStart(scheduleDTO.getStart());
        schedule.setEnd(scheduleDTO.getEnd());
        Room room = this.roomRepository.findById(scheduleDTO.getRoom()).orElse(null);
        Lecture lecture = this.lectureRepository.findById(scheduleDTO.getLecture()).orElse(null);
        schedule.setRoom(room);
        schedule.setLecture(lecture);
        return this.scheduleRepository.save(schedule);
    }

    public Schedule findScheduleById(Long scheduleId) {
        return this.scheduleRepository.findById(scheduleId).orElse(null);
    }

    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) this.scheduleRepository.findAll();
    }
}
