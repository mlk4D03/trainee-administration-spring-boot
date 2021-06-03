package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.CourseDTO;
import com.trivadis.administration.trainee.entities.Course;
import com.trivadis.administration.trainee.entities.Module;
import com.trivadis.administration.trainee.entities.Year;
import com.trivadis.administration.trainee.repository.CourseRepository;
import com.trivadis.administration.trainee.repository.ModuleRepository;
import com.trivadis.administration.trainee.repository.YearRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    private CourseRepository courseRepository;

    private YearRepository yearRepository;

    private ModuleRepository moduleRepository;

    public CourseService(CourseRepository courseRepository, YearRepository yearRepository, ModuleRepository moduleRepository) {
        this.courseRepository = courseRepository;
        this.yearRepository = yearRepository;
        this.moduleRepository = moduleRepository;
    }

    public Course saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        Optional<Year> year = this.yearRepository.findById(courseDTO.getYear());
        List<Module> modules = (List<Module>) this.moduleRepository.findAllById(courseDTO.getModules());
        course.setName(courseDTO.getName());
        course.setYear(year.orElse(null));
        course.setModules(modules);
        modules.stream().forEach(m -> m.setCourse(course));
        return  this.courseRepository.save(course);
    }

    public Iterable<Course> getAllCourses() {
        return this.courseRepository.findAll();
    }

    public Course findById(Long id) {
        return this.courseRepository.findById(id).orElse(null);
    }
}
