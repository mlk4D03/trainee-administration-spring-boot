package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.TraineeDTO;
import com.trivadis.administration.trainee.entities.Trainee;
import com.trivadis.administration.trainee.service.TraineeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainee")
public class TraineeController {

    private TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @PostMapping
    public TraineeDTO saveTrainee(@RequestBody TraineeDTO traineeDTO) {
        return this.toTraineeDTO(this.traineeService.saveTrainee(traineeDTO));
    }

    @GetMapping
    public List<TraineeDTO> getAllTrainees() {
        List<Trainee> trainees = (List<Trainee>) this.traineeService.getAllTrainees();
        return trainees.stream().map(this::toTraineeDTO).collect(Collectors.toList());
    }

    @GetMapping("/{traineeId}")
    public TraineeDTO getTraineeById(@PathVariable Long traineeId) {
        return this.toTraineeDTO(this.traineeService.findTraineeById(traineeId));
    }

    private TraineeDTO toTraineeDTO(Trainee trainee) {
        TraineeDTO traineeDTO = new TraineeDTO();
        if (trainee != null) {
            traineeDTO.setFirstName(trainee.getFirstName());
            traineeDTO.setLastName(trainee.getLastName());
            traineeDTO.setId(trainee.getId());
            if (trainee.getCourse() != null) {
                traineeDTO.setCourse(trainee.getCourse().getId());
            }
            if (trainee.getHabitat() != null) {
                traineeDTO.setHabitat(trainee.getHabitat().getId());
            }
        }
        return traineeDTO;
    }
}
