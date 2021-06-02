package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.ModuleDTO;
import com.trivadis.administration.trainee.entities.Lecture;
import com.trivadis.administration.trainee.entities.Module;
import com.trivadis.administration.trainee.repository.LectureRepository;
import com.trivadis.administration.trainee.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModuleService {

    private ModuleRepository moduleRepository;

    private LectureRepository lectureRepository;

    public ModuleService(ModuleRepository moduleRepository, LectureRepository lectureRepository) {
        this.moduleRepository = moduleRepository;
        this.lectureRepository = lectureRepository;
    }

    public Module saveModule(ModuleDTO moduleDTO) {
        Module module = new Module();
        module.setDurationInWeeks(moduleDTO.getDurationInWeeks());
        module.setName(moduleDTO.getName());
        List<Lecture> lecturesList = new ArrayList<>();
        for (Long lectureId : moduleDTO.getLectures()) {
            Optional<Lecture> lectureOptional = this.lectureRepository.findById(lectureId);
            if (lectureOptional.isPresent()) {
                Lecture lecture = lectureOptional.get();
                lecturesList.add(lecture);
                lecture.setModule(module);
            }
        }
        module.setLectures(lecturesList);
        return this.moduleRepository.save(module);
    }

    public Module getModuleById(Long id) {
        Optional<Module> byId = this.moduleRepository.findById(id);
        return byId.orElse(null);
    }

    public Iterable<Module> getAllModules() {
        return this.moduleRepository.findAll();
    }
}
