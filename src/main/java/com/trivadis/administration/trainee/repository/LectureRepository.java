package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<Lecture,Long> {
}
