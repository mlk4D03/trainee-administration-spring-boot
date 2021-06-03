package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
}
