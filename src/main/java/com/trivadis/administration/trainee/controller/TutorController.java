package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.TutorDTO;
import com.trivadis.administration.trainee.entities.Lecture;
import com.trivadis.administration.trainee.entities.Tutor;
import com.trivadis.administration.trainee.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    private TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public TutorDTO saveTutor(@RequestBody TutorDTO tutorDTO) {
        return transformToTutorDTO(this.tutorService.saveTutor(tutorDTO));
    }

    @GetMapping("/{tutorId}")
    public TutorDTO findTutorById(@PathVariable Long tutorId) {
        return transformToTutorDTO(this.tutorService.findTutorById(tutorId));
    }

    @GetMapping("/allTutors")
    public List<TutorDTO> getAllTutors() {
        List<Tutor> tutors = this.tutorService.getAllTutors();
        return tutors.stream().map(this::transformToTutorDTO).collect(Collectors.toList());
    }

    private TutorDTO transformToTutorDTO(Tutor tutor) {
        TutorDTO tutorDTO = new TutorDTO();
        tutorDTO.setFirstName(tutor.getFirstName());
        tutorDTO.setLastName(tutor.getLastName());
        tutorDTO.setId(tutor.getId());
        tutorDTO.setLectures(tutor.getLecture().stream().map(Lecture::getId).collect(Collectors.toList()));
        if (tutor.getHabitat() != null) {
            tutorDTO.setHabitat(tutor.getHabitat().getId());
        }
        return tutorDTO;
    }
}
