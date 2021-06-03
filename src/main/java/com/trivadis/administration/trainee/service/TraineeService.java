package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.TraineeDTO;
import com.trivadis.administration.trainee.entities.Course;
import com.trivadis.administration.trainee.entities.Habitat;
import com.trivadis.administration.trainee.entities.Trainee;
import com.trivadis.administration.trainee.repository.CourseRepository;
import com.trivadis.administration.trainee.repository.HabitatRepository;
import com.trivadis.administration.trainee.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TraineeService {

    private TraineeRepository traineeRepository;

    private CourseRepository courseRepository;

    private HabitatRepository habitatRepository;

    public TraineeService(TraineeRepository traineeRepository, CourseRepository courseRepository, HabitatRepository habitatRepository) {
        this.traineeRepository = traineeRepository;
        this.courseRepository = courseRepository;
        this.habitatRepository = habitatRepository;
    }

    public Trainee saveTrainee(TraineeDTO traineeDTO) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(traineeDTO.getFirstName());
        trainee.setLastName(traineeDTO.getLastName());
        Course course = this.courseRepository.findById(traineeDTO.getCourse()).orElse(null);
        Optional<Habitat> habitat = this.habitatRepository.findById(traineeDTO.getHabitat());
        trainee.setHabitat(habitat.orElse(null));
        if (course != null) {
            trainee.setCourse(course);
            course.getTrainees().add(trainee);
        }
        return this.traineeRepository.save(trainee);
    }

    public Iterable<Trainee> getAllTrainees() {
        return this.traineeRepository.findAll();
    }

    public Trainee findTraineeById(Long id) {
        return this.traineeRepository.findById(id).orElse(null);
    }
}
