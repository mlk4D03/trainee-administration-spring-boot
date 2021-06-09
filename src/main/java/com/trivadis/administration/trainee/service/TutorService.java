package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.TutorDTO;
import com.trivadis.administration.trainee.entities.Habitat;
import com.trivadis.administration.trainee.entities.Lecture;
import com.trivadis.administration.trainee.entities.Tutor;
import com.trivadis.administration.trainee.repository.HabitatRepository;
import com.trivadis.administration.trainee.repository.LectureRepository;
import com.trivadis.administration.trainee.repository.TutorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TutorService {

    private TutorRepository tutorRepository;

    private HabitatRepository habitatRepository;

    private LectureRepository lectureRepository;

    public TutorService(TutorRepository tutorRepository, HabitatRepository habitatRepository, LectureRepository lectureRepository) {
        this.tutorRepository = tutorRepository;
        this.habitatRepository = habitatRepository;
        this.lectureRepository = lectureRepository;
    }

    public Tutor saveTutor(TutorDTO tutorDTO) {
        Tutor tutor = new Tutor();
        tutor.setFirstName(tutorDTO.getFirstName());
        tutor.setLastName(tutorDTO.getLastName());
        Habitat habitat = this.habitatRepository.findById(tutorDTO.getHabitat()).orElse(null);
        List<Lecture> lectures = (List<Lecture>) this.lectureRepository.findAllById(tutorDTO.getLectures());
        tutor.setHabitat(habitat);
        tutor.setLecture(lectures);
        lectures.forEach(l -> l.setTutor(tutor));
        return this.tutorRepository.save(tutor);
    }

    public Tutor findTutorById(Long tutorId) {
        return this.tutorRepository.findById(tutorId).orElse(null);
    }

    public List<Tutor> getAllTutors() {
        return (List<Tutor>) this.tutorRepository.findAll();
    }

}
