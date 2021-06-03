package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.CourseDTO;
import com.trivadis.administration.trainee.entities.Course;
import com.trivadis.administration.trainee.entities.Module;
import com.trivadis.administration.trainee.entities.Trainee;
import com.trivadis.administration.trainee.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
        return toCourseDTO(this.courseService.saveCourse(courseDTO));
    }

    @GetMapping("/allCourses")
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = (List<Course>) this.courseService.getAllCourses();
        return courses.stream().map(this::toCourseDTO).collect(Collectors.toList());
    }

    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable Long courseId) {
        return this.toCourseDTO(this.courseService.findById(courseId));
    }


    private CourseDTO toCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(course.getName());
        if (course.getModules() != null) {
            courseDTO.setModules(course.getModules().stream().map(Module::getId).collect(Collectors.toList()));
        }
        if (course.getTrainees() != null) {
            courseDTO.setTrainees(course.getTrainees().stream().map(Trainee::getId).collect(Collectors.toList()));
        }
        courseDTO.setYear(course.getYear().getId());
        courseDTO.setId(course.getId());
        return courseDTO;
    }
}
