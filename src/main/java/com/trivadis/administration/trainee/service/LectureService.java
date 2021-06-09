package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.LectureDTO;
import com.trivadis.administration.trainee.entities.Lecture;
import com.trivadis.administration.trainee.repository.LectureRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class LectureService {

    private LectureRepository lectureRepository;


    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Lecture saveLecture(LectureDTO lectureDTO) {
        Lecture lecture = new Lecture();
        lecture.setDescription(lectureDTO.getDiscription());
        lecture.setName(lectureDTO.getName());
        return this.lectureRepository.save(lecture);
    }

    public Iterable<Lecture> getAllLectures() {
        return this.lectureRepository.findAll();
    }

    public Lecture getLectureById(Long id) {
        Optional<Lecture> byId = this.lectureRepository.findById(id);
        return byId.orElse(null);
    }
}
