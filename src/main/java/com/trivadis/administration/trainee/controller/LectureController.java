package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.LectureDTO;
import com.trivadis.administration.trainee.entities.Lecture;
import com.trivadis.administration.trainee.service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    private LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping
    public LectureDTO saveLecture(@RequestBody LectureDTO lectureDTO) {
        Lecture lecture = this.lectureService.saveLecture(lectureDTO);

        return toLectureDTO(lecture);
    }

    @GetMapping("/allLectures")
    public Iterable<LectureDTO> getAllLectures() {
        Collection<Lecture> lecture = (Collection<Lecture>) this.lectureService.getAllLectures();

        return lecture.stream().map(this::toLectureDTO).collect(Collectors.toList());
    }

    @GetMapping("/{lectureId}")
    public LectureDTO getLectureById(@PathVariable Long lectureId) {
        Lecture lectureById = this.lectureService.getLectureById(lectureId);
        if (lectureById != null) {
            return toLectureDTO(lectureById);
        }
        return null;
    }

    private LectureDTO toLectureDTO(Lecture lecture) {
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.setId(lecture.getId());
        lectureDTO.setDiscription(lecture.getDescription());
        if (lecture.getModule() != null) {
            lectureDTO.setModule(lecture.getModule().getId());
        }
        if (lecture.getTutor() != null) {
            lectureDTO.setTutor(lecture.getTutor().getId());
        }
        lectureDTO.setName(lecture.getName());

        return lectureDTO;
    }
}
